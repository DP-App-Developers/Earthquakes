package com.sample.earthquakes

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class EarthquakesServiceTest {

    @Test
    fun `verify that the json response is converted to the model object`() {
        val service = EarthquakeServiceFactory().makeEarthquakeService()
        val earthquakesList = service.getEarthquakes(true, 44.1, -9.9, -22.4, 55.2, "mkoppelman").execute()
        assertThat(earthquakesList.body()?.earthquakesList?.size, `is`(10))
    }

}