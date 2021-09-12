package com.android.academy.mentorpetproject.data

import com.google.gson.annotations.SerializedName

data class Message(
    @SerializedName("retriever") val retrievers: List<String>,
    @SerializedName("spaniel") val spaniels: List<String>
)