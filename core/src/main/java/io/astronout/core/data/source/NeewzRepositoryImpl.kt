package io.astronout.core.data.source

import com.skydoves.sandwich.ApiResponse
import io.astronout.core.data.source.local.LocalDataSource
import io.astronout.core.data.source.mapper.toDomain
import io.astronout.core.data.source.mapper.toEntity
import io.astronout.core.data.source.remote.RemoteDataSource
import io.astronout.core.data.source.remote.dto.TopHeadlineResponse
import io.astronout.core.domain.model.Article
import io.astronout.core.domain.repository.NeewzRepository
import io.astronout.core.vo.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class NeewzRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : NeewzRepository {

    override fun getTopHeadline(): Flow<Resource<List<Article>>> =
        object : NetworkBoundResource<List<Article>, TopHeadlineResponse>() {
            override fun loadFromDB(): Flow<List<Article>> {
                return localDataSource.getAllArticles().map {
                    it.toDomain()
                }
            }

            override fun shouldFetch(data: List<Article>?): Boolean =
                true

            override suspend fun createCall(): ApiResponse<TopHeadlineResponse> =
                remoteDataSource.getTopHeadline()

            override suspend fun saveCallResult(data: TopHeadlineResponse) {
                localDataSource.insertArticles(data.toEntity())
            }
        }.asFlow()

}
