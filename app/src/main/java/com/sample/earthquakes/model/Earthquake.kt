package com.sample.earthquakes.model

import com.google.gson.annotations.SerializedName

data class Earthquake(
    @SerializedName("magnitude")
    val magnitude: Double,
    @SerializedName("lng")
    val lng: Double,
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("datetime")
    val datetime: String,
    @SerializedName("depth")
    val depth: String,
    @SerializedName("eqid")
    val eqid: String,
    @SerializedName("src")
    val src: String
)