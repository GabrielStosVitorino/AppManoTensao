package com.example.manotenso

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DistanceMatrixService {
    @GET("/maps/api/distancematrix/json")
    fun getDistance(
        @Query("origins") origins: String,
        @Query("destinations") destinations: String,
        @Query("key") apiKey: String = "AIzaSyD5UIc9vzGyEavKShflmwUOlYIk8sax8xU"
    ): Call<DistanceResponse>
}