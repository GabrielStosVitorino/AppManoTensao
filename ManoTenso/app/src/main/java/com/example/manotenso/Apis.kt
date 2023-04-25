package com.example.manotenso

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Apis {
    var BASE_URL = "http://23.21.241.160:8090/"

    fun getApi(): Api {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()

        return retrofit.create(Api::class.java)
    }
}