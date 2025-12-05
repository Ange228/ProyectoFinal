package com.example.flexapp.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRettrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://flexapp-and-default-rtdb.firebaseio.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}