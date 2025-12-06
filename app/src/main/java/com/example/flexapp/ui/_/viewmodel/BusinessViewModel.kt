package com.example.flexapp.ui.business.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flexapp.data.repository.BusinessRepositoryImpl
import com.example.flexapp.domain.model.Business
import kotlinx.coroutines.launch

class BusinessViewModel : ViewModel() {

    val isLoading = MutableLiveData<Boolean>()
    val message = MutableLiveData<String>()

    private val repo = BusinessRepositoryImpl()

    fun registerBusiness(business: Business) {
        viewModelScope.launch {
            isLoading.postValue(true)
            val ok = repo.registerBusiness(business)
            isLoading.postValue(false)

            message.postValue(
                if (ok) "Negocio registrado"
                else "Error al registrar negocio"
            )
        }
    }
}
