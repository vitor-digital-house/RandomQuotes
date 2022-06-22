package com.example.randomquotes.data

import com.example.randomquotes.data.model.Quote
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteApi {

    @GET("api/1.0/")
    suspend fun getRandomQuote(
        @Query("method") method: String = "getQuote",
        @Query("lang") lang: String = "en",
        @Query("format") format: String = "json",
    ): Quote
}