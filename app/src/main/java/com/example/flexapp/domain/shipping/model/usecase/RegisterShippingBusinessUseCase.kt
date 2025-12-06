package com.example.flexapp.domain.shipping.model.usecase

import com.example.flexapp.domain.shipping.model.ShippingBusiness
import com.example.flexapp.domain.shipping.repository.ShippingBusinessRepository

class RegisterShippingBusinessUseCase(
    private val repository: ShippingBusinessRepository
) {
    suspend operator fun invoke(business: ShippingBusiness) {
        repository.registerBusiness(business)
    }
}
