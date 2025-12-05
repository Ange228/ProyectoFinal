package com.example.flexapp.ui._.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.flexapp.data.model._.model.QuoteModel
import com.example.flexapp.data.model._.model.QuoteProvider

class QuoteViewModel: ViewModel() {
    val quoteModel = MutableLiveData<QuoteModel>()

    fun randomQuote(){
        val currentQuote = QuoteProvider.Companion.random()
        quoteModel.postValue(currentQuote)
    }
}