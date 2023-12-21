package io.astronout.core.data.source.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TopHeadlineResponse(
    @Json(name = "status")
    val status: String? = null,
    @Json(name = "totalResults")
    val totalResults: Int? = null,
    @Json(name = "articles")
    val articles: List<ArticleResponse>? = null
)