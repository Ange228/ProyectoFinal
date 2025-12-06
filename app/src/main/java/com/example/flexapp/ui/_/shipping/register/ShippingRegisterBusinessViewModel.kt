package com.example.flexapp.ui._.shipping.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flexapp.domain.shipping.model.ShippingBusiness
import com.example.flexapp.domain.shipping.model.usecase.RegisterShippingBusinessUseCase
import kotlinx.coroutines.launch


class ShippingRegisterBusinessViewModel(
    private val registerUseCase: RegisterShippingBusinessUseCase
) : ViewModel() {

    fun registerBusiness(business: ShippingBusiness, onDone: () -> Unit) {
        viewModelScope.launch {
            registerUseCase(business)
            onDone()
        }
    }
}
