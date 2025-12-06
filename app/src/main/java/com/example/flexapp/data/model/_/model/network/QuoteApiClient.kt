package com.example.flexapp.data.model._.model.network

import com.example.flexapp.data.model._.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {
    @GET("quote.json")
    suspend fun getAllQuotes():Response<List<QuoteModel>>
}