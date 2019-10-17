package com.sample.earthquakes.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sample.earthquakes.api.EarthquakesService
import com.sample.earthquakes.model.Earthquake
import com.sample.earthquakes.model.EarthquakesList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EarthquakesRepository {

    private val earthquakesService by lazy {
        EarthquakesService.create()
    }

    fun fetchEarthquakes(): LiveData<List<Earthquake>> {
        val data = MutableLiveData<List<Earthquake>>()
        val earthquakesList = earthquakesService.getEarthquakes(true, 44.1, -9.9, -22.4, 55.2, "mkoppelman")
        earthquakesList.enqueue(object : Callback<EarthquakesList>{
            override fun onResponse(call: Call<EarthquakesList>, response: Response<EarthquakesList>) {
                data.value = response.body()?.earthquakesList
            }

            override fun onFailure(call: Call<EarthquakesList>, t: Throwable) {
            }
        })
        return data
    }

}