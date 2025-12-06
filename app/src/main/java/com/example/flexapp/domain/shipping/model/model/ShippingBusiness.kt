package com.example.flexapp.domain.shipping.model

data class ShippingBusiness(
    val id: Int = 0,
    val name: String,
    val owner: String,
    val type: String,
    val phone: String
)
