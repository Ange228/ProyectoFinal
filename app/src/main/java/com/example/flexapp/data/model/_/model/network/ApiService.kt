package com.example.flexapp.data.network

import com.example.flexapp.domain.model.Business
import com.example.flexapp.domain.model.Order
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    // --- BUSINESS ---
    @POST("businesses.json")
    suspend fun postBusiness(@Body business: Business): Response<Map<String, String>>

    @GET("businesses.json")
    suspend fun getBusinesses(): Response<Map<String, Business>>

    // --- ORDERS ---
    @POST("orders.json")
    suspend fun postOrder(@Body order: Order): Response<Map<String, String>>

    @GET("orders.json")
    suspend fun getOrders(): Response<Map<String, Order>>
}
