package com.example.flexapp.data.model._.model

import com.example.flexapp.data.model._.model.network.QuoteService

class QuoteRepository {
    private val api = QuoteService()

    suspend fun getAllQuotes():List<QuoteModel>{
        val response = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }
}