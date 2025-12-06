package com.example.flexapp.domain.shipping.repository

import com.example.flexapp.domain.shipping.model.ShippingBusiness

interface ShippingBusinessRepository {
    suspend fun registerBusiness(business: ShippingBusiness)
    suspend fun getBusiness(): ShippingBusiness?
    suspend fun registerShippingBusiness(business: ShippingBusiness)
}
