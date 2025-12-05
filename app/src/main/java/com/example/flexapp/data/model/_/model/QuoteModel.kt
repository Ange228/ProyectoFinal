package com.example.flexapp.data.model._.model

import com.google.gson.annotations.SerializedName

data class QuoteModel (@SerializedName("quote") val quote: String, @SerializedName("message") val message: String)