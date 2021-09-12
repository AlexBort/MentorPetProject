package com.android.academy.mentorpetproject.api

import com.android.academy.mentorpetproject.api.OkkHttpClientInstance.client
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val BASE_URL = "https://dog.ceo/api/"

    private val retrofit by lazy {
        Retrofit.Builder().baseUrl(BASE_URL).client(client)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }


    val api:IApiRequests by lazy {
        retrofit.create(IApiRequests::class.java)
    }
}