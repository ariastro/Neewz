package io.astronout.core.data.source.remote

import com.skydoves.sandwich.ApiResponse
import io.astronout.core.data.source.remote.dto.TopHeadlineResponse

interface RemoteDataSource {
    suspend fun getTopHeadline(): ApiResponse<TopHeadlineResponse>
}

