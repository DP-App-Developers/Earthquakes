package com.sample.earthquakes.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.sample.earthquakes.R
import com.sample.earthquakes.viewmodel.EarthquakesViewModel

class MapFragment : Fragment() {
    private lateinit var viewModel: EarthquakesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = activity?.run {
            ViewModelProviders.of(this)[EarthquakesViewModel::class.java]
        } ?: throw Exception("Invalid Activity")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.map_fragment, container, false)
        val mapFragment = SupportMapFragment.newInstance()
        mapFragment.getMapAsync { map ->
            val position = arguments?.getInt(LIST_POSITION) as Int
            val earthquake = viewModel.data.value?.get(position)
            earthquake?.let {
                val lat = it.lat
                val lng = it.lng
                val location = LatLng(lat, lng)
                map.addMarker(MarkerOptions().position(location).title("lat: $lat, lng: $lng"))
                map.moveCamera(CameraUpdateFactory.newLatLng(location))
            }
        }

        childFragmentManager.beginTransaction().replace(R.id.map_fragment_container, mapFragment).commit()
        return view
    }
}
const val LIST_POSITION = "key_list_position"