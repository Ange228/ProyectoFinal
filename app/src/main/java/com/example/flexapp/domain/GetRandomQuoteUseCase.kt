package com.example.flexapp.domain

import com.example.flexapp.data.model._.model.QuoteModel
import com.example.flexapp.data.model._.model.QuoteProvider

class GetRandomQuoteUseCase {

    operator fun invoke(): QuoteModel?{
        val quotes = QuoteProvider.quotes
        if(!quotes.isNullOrEmpty()) {
                val randomNumber = (quotes.indices).random()
                return quotes[randomNumber]
            }
            return null
    }

}
