package com.example.flexapp.data.shipping.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shipping_business")
data class ShippingBusinessEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val owner: String,
    val type: String,
    val phone: String
)
