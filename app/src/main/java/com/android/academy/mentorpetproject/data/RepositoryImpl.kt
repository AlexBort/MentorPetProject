package com.android.academy.mentorpetproject.data

import com.android.academy.mentorpetproject.api.RetrofitInstance
import retrofit2.Response

class RepositoryImpl : Repository {
    override suspend fun getBreedsList(): Response<All> {
       return RetrofitInstance.api.getBreeds()
    }

    override suspend fun getBreedInfo() {

    }
}