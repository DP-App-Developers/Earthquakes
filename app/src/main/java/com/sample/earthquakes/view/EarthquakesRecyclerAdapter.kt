package com.sample.earthquakes.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sample.earthquakes.R
import com.sample.earthquakes.model.Earthquake
import kotlinx.android.synthetic.main.earthquake_list_item.view.*
import java.util.*

class EarthquakesRecyclerAdapter internal constructor(
    context: Context, private val itemClickListener: OnItemClickListener
) : RecyclerView.Adapter<EarthquakesRecyclerAdapter.EarthquakeViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var earthquakes = Collections.emptyList<Earthquake>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EarthquakeViewHolder {
        val itemView = inflater.inflate(R.layout.earthquake_list_item, parent, false)
        return EarthquakeViewHolder(itemView)
    }

    override fun getItemCount() = earthquakes.size

    override fun onBindViewHolder(holder: EarthquakeViewHolder, position: Int) {
        val current = earthquakes[position]
        with(holder) {
            magnitude.text = current.magnitude
            lng.text = current.lng.toString()
            lat.text = current.lat.toString()
            datetime.text = current.datetime
            depth.text = current.depth
            eqid.text = current.eqid
            src.text = current.src
            itemView.setOnClickListener {
                itemClickListener.openMap(position)
            }
        }
    }

    internal fun setData(earthquakes: List<Earthquake>) {
        this.earthquakes = earthquakes
        notifyDataSetChanged()
    }

    inner class EarthquakeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val magnitude: TextView = itemView.magnitude
        val lng: TextView = itemView.lng
        val lat: TextView = itemView.lat
        val datetime: TextView = itemView.datetime
        val depth: TextView = itemView.depth
        val eqid: TextView = itemView.eqid
        val src: TextView = itemView.src
    }

    interface OnItemClickListener {
        fun openMap(position: Int)
    }
}