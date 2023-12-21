package io.astronout.core.domain.repository

import io.astronout.core.domain.model.Article
import io.astronout.core.vo.Resource
import kotlinx.coroutines.flow.Flow

interface NeewzRepository {

    fun getTopHeadline(): Flow<Resource<List<Article>>>

}
