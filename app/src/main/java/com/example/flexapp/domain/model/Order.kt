package com.example.flexapp.domain.model

import androidx.room.Entity

@Entity(tableName = "orders")
data class Order(
    val id: String? = null,
    val customerName: String = "",
    val customerAddress: String = "",
    val quantity: Int = 1,
    val amount: Double = 0.0,
    val status: String = "pendiente",
    val date: Long = System.currentTimeMillis()
)
