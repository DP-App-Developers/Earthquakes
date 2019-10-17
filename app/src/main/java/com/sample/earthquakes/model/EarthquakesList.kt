package com.sample.earthquakes.model

import com.google.gson.annotations.SerializedName

data class EarthquakesList(
    @SerializedName("earthquakes")
    val earthquakesList: List<Earthquake>
)