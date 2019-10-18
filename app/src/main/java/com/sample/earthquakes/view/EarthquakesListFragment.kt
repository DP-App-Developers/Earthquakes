package com.sample.earthquakes.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sample.earthquakes.R
import com.sample.earthquakes.viewmodel.EarthquakesViewModel

class EarthquakesListFragment : Fragment(), EarthquakesRecyclerAdapter.OnItemClickListener {
    private lateinit var adapter: EarthquakesRecyclerAdapter
    private lateinit var viewModel: EarthquakesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = activity?.run {
            ViewModelProviders.of(this)[EarthquakesViewModel::class.java]
        } ?: throw Exception("Invalid Activity")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.earthquakes_list_fragment, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.earthquakes_recycler_view)
        adapter = EarthquakesRecyclerAdapter(this.activity as Context, this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this.activity as Context)
        recyclerView.addItemDecoration(DividerItemDecoration(this.activity as Context, LinearLayoutManager.VERTICAL))
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.data.observe(this, Observer { earthquakes ->
            adapter.setData(earthquakes)
        })
    }

    override fun openMap(position: Int) {
        val mapFragment = MapFragment()
        val arguments = Bundle()
        arguments.putInt(LIST_POSITION, position)
        mapFragment.arguments = arguments
        fragmentManager?.beginTransaction()?.apply {
            replace(R.id.fragment_container, mapFragment)
            addToBackStack(null)
            commit()
        }
    }
}