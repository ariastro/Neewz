package io.astronout.core.domain.usecase

import io.astronout.core.domain.model.Article
import io.astronout.core.domain.repository.NeewzRepository
import io.astronout.core.vo.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TopHeadlineUsecase @Inject constructor (
    private val repository: NeewzRepository
): UseCase<NoParams, Flow<Resource<List<Article>>>> {
    override fun invoke(param: NoParams): Flow<Resource<List<Article>>> {
        return repository.getTopHeadline()
    }
}