package com.example.flexapp.ui._.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flexapp.data.model._.model.QuoteModel
import com.example.flexapp.domain.GetQuotesUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class QuoteViewModel : ViewModel() {

    val quoteModel = MutableLiveData<QuoteModel>()
    val isLoading = MutableLiveData<Boolean>()
    val showStartButton = MutableLiveData<Boolean>()

    private var quotes: List<QuoteModel> = emptyList()
    private var index = 0

    private val getQuotesUseCase = GetQuotesUseCase()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            delay(900)

            val result = getQuotesUseCase()

            if (!result.isNullOrEmpty()) {
                quotes = result
                index = 0
                quoteModel.postValue(quotes[index])
                updateButtonVisibility()
            }

            isLoading.postValue(false)
        }
    }

    fun nextQuote() {
        if (index < quotes.size - 1) {
            index++
            quoteModel.postValue(quotes[index])
            updateButtonVisibility()
        }
    }

    private fun updateButtonVisibility() {
        showStartButton.postValue(index == quotes.size - 1)
    }
}
