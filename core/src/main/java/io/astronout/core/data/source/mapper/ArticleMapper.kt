package io.astronout.core.data.source.mapper

import io.astronout.core.data.source.local.entity.ArticleEntity
import io.astronout.core.data.source.remote.dto.TopHeadlineResponse
import io.astronout.core.domain.model.Article

fun List<ArticleEntity>.toDomain(): List<Article> {
    return map {
        Article(
            source = it.source,
            author = it.author,
            title = it.title,
            description = it.description,
            url = it.url,
            urlToImage = it.urlToImage,
            publishedAt = it.publishedAt,
            content = it.content,
        )
    }
}

fun TopHeadlineResponse.toEntity(): List<ArticleEntity> {
    return articles?.map {
        ArticleEntity(
            source = it.source?.name.orEmpty(),
            author = it.author.orEmpty(),
            title = it.title.orEmpty(),
            description = it.description.orEmpty(),
            url = it.url.orEmpty(),
            urlToImage = it.urlToImage.orEmpty(),
            publishedAt = it.publishedAt.orEmpty(),
            content = it.content.orEmpty(),
        )
    }.orEmpty()
}