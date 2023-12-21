package io.astronout.core.data.source.local

import io.astronout.core.data.source.local.entity.ArticleEntity
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    fun getAllArticles(): Flow<List<ArticleEntity>>
    suspend fun insertArticles(articles: List<ArticleEntity>)

}