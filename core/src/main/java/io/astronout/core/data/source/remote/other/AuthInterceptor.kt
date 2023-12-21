package io.astronout.core.data.source.remote.other

import io.astronout.core.BuildConfig
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val url = originalRequest.url.newBuilder().addQueryParameter("apiKey", BuildConfig.NEWS_TOKEN).build()
        return chain.proceed(originalRequest.newBuilder().url(url).build())
    }
}