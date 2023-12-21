package io.astronout.core.data.source.remote.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ArticleResponse(
    @Json(name = "source")
    val source: SourceResponse? = null,
    @Json(name = "author")
    val author: String? = null,
    @Json(name = "title")
    val title: String? = null,
    @Json(name = "description")
    val description: String? = null,
    @Json(name = "url")
    val url: String? = null,
    @Json(name = "urlToImage")
    val urlToImage: String? = null,
    @Json(name = "publishedAt")
    val publishedAt: String? = null,
    @Json(name = "content")
    val content: String? = null
)