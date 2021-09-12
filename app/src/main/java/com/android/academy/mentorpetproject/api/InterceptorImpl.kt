package com.android.academy.mentorpetproject.api

import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor

class InterceptorImpl(private val contentType: String) : Interceptor {
    private val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val modifiedRequest = originalRequest
            .newBuilder()
            .header("Content-Type", contentType)
            .header("User-Agent", "okhttp/4.5.0")
            .build()
        logger.intercept(chain)
        return chain.proceed(modifiedRequest)
    }
}