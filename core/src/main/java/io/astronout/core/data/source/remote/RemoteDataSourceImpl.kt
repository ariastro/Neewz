package io.astronout.core.data.source.remote

import com.skydoves.sandwich.ApiResponse
import io.astronout.core.data.source.remote.dto.TopHeadlineResponse
import io.astronout.core.data.source.remote.web.ApiService
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val api: ApiService): RemoteDataSource {

    override suspend fun getTopHeadline(): ApiResponse<TopHeadlineResponse> {
        return api.getTopHeadline()
    }

}

