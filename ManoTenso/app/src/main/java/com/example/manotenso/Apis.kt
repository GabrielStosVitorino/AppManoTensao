package com.example.manotenso

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Apis {
    var BASE_URL_BACK = "http://23.21.241.160:8090/"
    var BASE_URL_DISTANCE_MATRIX = "https://maps.googleapis.com"

    fun getApi(): Api {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL_BACK)
            .build()

        return retrofit.create(Api::class.java)
    }

    fun getDistanceMatrix(): DistanceMatrixService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL_DISTANCE_MATRIX)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(DistanceMatrixService::class.java)
    }
}