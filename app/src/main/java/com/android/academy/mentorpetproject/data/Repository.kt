package com.android.academy.mentorpetproject.data

import retrofit2.Response

interface Repository {
    suspend fun getBreedsList(): Response<All>
    suspend fun getBreedInfo()
}
