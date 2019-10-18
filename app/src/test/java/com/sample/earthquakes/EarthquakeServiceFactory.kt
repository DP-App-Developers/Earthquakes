package com.sample.earthquakes

import com.sample.earthquakes.api.EarthquakesService

class EarthquakeServiceFactory {

    fun makeEarthquakeService(): EarthquakesService {
        return EarthquakesService.create()
    }
}