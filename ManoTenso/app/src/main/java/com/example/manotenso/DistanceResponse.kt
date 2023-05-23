package com.example.manotenso

import com.google.gson.annotations.SerializedName

data class DistanceResponse(
    @field:SerializedName("origin_addresses") val origin: List<String>,
    @field:SerializedName("destination_addresses") val destination: List<String>,
    val rows: List<Row>
)

data class Element(val distance: Distance,
                   val duration: Duration)

data class Row(val elements: List<Element>)
