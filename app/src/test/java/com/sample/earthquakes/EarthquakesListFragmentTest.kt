package com.sample.earthquakes

import com.sample.earthquakes.view.EarthquakesListFragment
import com.sample.earthquakes.view.LIST_POSITION
import com.sample.earthquakes.view.MainActivity
import com.sample.earthquakes.view.MapFragment
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class EarthquakesListFragmentTest {

    @Test
    fun `verify that the MapFragment shows the correct earthquake`() {
        val activity = Robolectric.buildActivity(MainActivity::class.java).create().get()
        val listFragment = activity.supportFragmentManager.findFragmentById(R.id.fragment_container) as EarthquakesListFragment
        listFragment.openMap(9)
        val mapFragment = activity.supportFragmentManager.findFragmentById(R.id.fragment_container) as MapFragment
        assertThat(mapFragment.arguments?.getInt(LIST_POSITION), `is`(9))
    }

}