package com.sample.earthquakes.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.sample.earthquakes.model.Earthquake
import com.sample.earthquakes.repository.EarthquakesRepository

class EarthquakesViewModel : ViewModel() {
    private val repository: EarthquakesRepository = EarthquakesRepository()
    val data: LiveData<List<Earthquake>> by lazy {
        repository.fetchEarthquakes()
    }
}