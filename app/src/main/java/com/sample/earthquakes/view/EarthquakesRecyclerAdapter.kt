package com.sample.earthquakes.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sample.earthquakes.R
import com.sample.earthquakes.model.Earthquake
import java.util.*

class EarthquakesRecyclerAdapter internal constructor(
    context: Context
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
        holder.magnitude.text = current.magnitude
        holder.lng.text = current.lng
        holder.lat.text = current.lat
        holder.datetime.text = current.datetime
        holder.depth.text = current.depth
        holder.eqid.text = current.eqid
        holder.src.text = current.src
    }

    internal fun setData(earthquakes: List<Earthquake>) {
        this.earthquakes = earthquakes
        notifyDataSetChanged()
    }

    inner class EarthquakeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val magnitude: TextView = itemView.findViewById(R.id.magnitude)
        val lng: TextView = itemView.findViewById(R.id.lng)
        val lat: TextView = itemView.findViewById(R.id.lat)
        val datetime: TextView = itemView.findViewById(R.id.datetime)
        val depth: TextView = itemView.findViewById(R.id.depth)
        val eqid: TextView = itemView.findViewById(R.id.eqid)
        val src: TextView = itemView.findViewById(R.id.src)
    }
}