package com.sample.earthquakes.model

import com.google.gson.annotations.SerializedName

data class Earthquake(
    @SerializedName("magnitude")
    val magnitude: String,
    @SerializedName("lng")
    val lng: String,
    @SerializedName("lat")
    val lat: String,
    @SerializedName("datetime")
    val datetime: String,
    @SerializedName("depth")
    val depth: String,
    @SerializedName("eqid")
    val eqid: String,
    @SerializedName("src")
    val src: String
)