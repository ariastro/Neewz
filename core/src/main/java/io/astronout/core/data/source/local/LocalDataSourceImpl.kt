package io.astronout.core.data.source.local

import io.astronout.core.data.source.local.entity.ArticleEntity
import io.astronout.core.data.source.local.room.NeewzDatabase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val appDatabase: NeewzDatabase
) : LocalDataSource {

    override fun getAllArticles(): Flow<List<ArticleEntity>> {
        return appDatabase.articleDao().getAllArticles()
    }

    override suspend fun insertArticles(articles: List<ArticleEntity>) {
        appDatabase.articleDao().insertArticles(articles)
    }

}