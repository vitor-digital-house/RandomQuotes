package com.example.randomquotes.data.model

import com.google.gson.annotations.SerializedName

data class Quote(
    @SerializedName("quoteText")
    val message: String,
    @SerializedName("quoteAuthor")
    val author: String,
)
