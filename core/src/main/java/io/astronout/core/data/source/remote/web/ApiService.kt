package io.astronout.core.data.source.remote.web

import com.skydoves.sandwich.ApiResponse
import io.astronout.core.data.source.remote.dto.TopHeadlineResponse
import retrofit2.http.GET

interface ApiService {

    @GET("v2/top-headlines?country=us")
    suspend fun getTopHeadline(): ApiResponse<TopHeadlineResponse>

}