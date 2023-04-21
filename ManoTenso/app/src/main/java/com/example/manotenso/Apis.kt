package com.example.manotenso

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Apis {
    var BASE_URL = "https://5f861cfdc8a16a0016e6aacd.mockapi.io/sptech-api/"

    fun getApiUsuarios(): Api {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()

        return retrofit.create(Api::class.java)
    }
}