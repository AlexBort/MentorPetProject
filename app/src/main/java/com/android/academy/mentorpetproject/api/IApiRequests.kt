package com.android.academy.mentorpetproject.api

import com.android.academy.mentorpetproject.data.All
import retrofit2.Response
import retrofit2.http.GET

interface IApiRequests {

    //  val BASE_URL = "https://dog.ceo/api/"
    @GET("breeds/list/")
    suspend fun getBreeds(): Response<All>
}