package com.example.flexapp.data.network

import com.example.flexapp.core.RetrofitHelper

object ApiServiceInstance {
    val api: ApiService = RetrofitHelper.getRetrofit()
        .create(ApiService::class.java)
}
