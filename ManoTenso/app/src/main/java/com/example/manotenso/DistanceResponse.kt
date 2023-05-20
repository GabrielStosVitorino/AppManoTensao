package com.example.manotenso

data class DistanceResponse(
    val origin: String,
    val destination: String,
    val distance: Distance,
    val duration: Duration
)
