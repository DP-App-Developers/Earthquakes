package com.sample.earthquakes

import com.sample.earthquakes.view.MainActivity
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class MainActivityTest {

    @Test
    fun `verify that the list fragment is added to the activity`() {
        val activity = Robolectric.buildActivity(MainActivity::class.java).create().get()
        assertThat(activity.supportFragmentManager.findFragmentById(R.id.fragment_container)?.isAdded, `is`(true))
    }

}