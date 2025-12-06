package com.example.flexapp.domain.model

import androidx.room.Entity

@Entity(tableName = "business")
data class Business(
    val id: String? = null,
    val name: String = "",
    val type: String = "",
    val phone: String = "",
    val city: String = "",
    val address: String = "",
    val ruc: String? = null
)