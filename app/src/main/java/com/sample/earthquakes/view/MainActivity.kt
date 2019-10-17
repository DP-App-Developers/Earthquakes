package com.sample.earthquakes.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sample.earthquakes.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val listFragment = EarthquakesListFragment()
            supportFragmentManager.beginTransaction().add(R.id.fragment_container, listFragment).commit()
        }
    }
}
