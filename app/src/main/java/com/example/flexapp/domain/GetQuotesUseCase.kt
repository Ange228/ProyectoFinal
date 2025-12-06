package com.example.flexapp.domain

import com.example.flexapp.data.model._.model.QuoteModel
import com.example.flexapp.data.model._.model.QuoteRepository

class GetQuotesUseCase {

    private var repository = QuoteRepository()

    suspend operator fun invoke():List<QuoteModel>? = repository.getAllQuotes()

}