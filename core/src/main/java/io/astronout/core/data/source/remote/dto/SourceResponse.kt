package io.astronout.core.data.source.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SourceResponse(
    @Json(name = "id")
    val id: String? = null,
    @Json(name = "name")
    val name: String? = null
)