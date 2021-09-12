package com.android.academy.mentorpetproject.api

import okhttp3.OkHttpClient

object OkkHttpClientInstance {
    val client by lazy {
        OkHttpClient.Builder().addInterceptor(
            InterceptorImpl("application/json")).build()
    }

}