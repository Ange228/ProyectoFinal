package com.example.flexapp.ui._.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flexapp.data.model._.model.QuoteModel
import com.example.flexapp.data.model._.model.QuoteProvider
import com.example.flexapp.domain.GetQuotesUseCase
import kotlinx.coroutines.launch

class QuoteViewModel: ViewModel() {
    val quoteModel = MutableLiveData<QuoteModel>()
    val isLoading
    var getQuotesUseCase = GetQuotesUseCase()

    fun onCreate(){
        viewModelScope.launch {
            val result: List<QuoteModel>? = getQuotesUseCase()

            if(!result.isNullOrEmpty()){
                quoteModel.postValue(result[0])
            }
        }

    }
}
    fun randomQuote(){
        //val currentQuote = QuoteProvider.Companion.random()
        //quoteModel.postValue(currentQuote)
    }