package com.example.flexapp.data.repository
import com.example.flexapp.data.network.ApiServiceInstance
import com.example.flexapp.domain.model.Business

class BusinessRepositoryImpl {

    private val api = ApiServiceInstance.api

    suspend fun registerBusiness(business: Business): Boolean {
        val response = api.postBusiness(business)
        return response.isSuccessful
    }
}
