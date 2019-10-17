package com.sample.earthquakes.api

import com.sample.earthquakes.model.EarthquakesList
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface EarthquakesService {

    @GET("/earthquakesJSON")
    fun getEarthquakes(@Query("formatted") formatted: Boolean,
                       @Query("north") north: Double,
                       @Query("south") south: Double,
                       @Query("east") east: Double,
                       @Query("west") west: Double,
                       @Query("username") username: String): Call<EarthquakesList>

    companion object {
        fun create(): EarthquakesService {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://api.geonames.org/")
                .build()

            return retrofit.create(EarthquakesService::class.java)
        }
    }

}