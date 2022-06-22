package com.example.randomquotes.data

import com.example.randomquotes.data.model.Quote
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class QuoteRepository {
    private val api = retrofit.create(QuoteApi::class.java)

    suspend fun getRandomQuote(): Quote = withContext(Dispatchers.IO) {
        api.getRandomQuote()
    }
}