package com.example.flexapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.flexapp.model.QuoteModel
import com.example.flexapp.model.QuoteProvider

class QuoteViewModel: ViewModel () {
    val quoteModel = MutableLiveData<QuoteModel>()

    fun randomQuote(){
        val currentQuote = QuoteProvider.random()
        quoteModel.postValue(currentQuote)
    }
}

