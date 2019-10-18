package com.sample.earthquakes.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sample.earthquakes.R
import com.sample.earthquakes.databinding.EarthquakeListItemBinding
import com.sample.earthquakes.model.Earthquake
import java.util.*

class EarthquakesRecyclerAdapter internal constructor(
    context: Context, private val itemClickListener: OnItemClickListener
) : RecyclerView.Adapter<EarthquakesRecyclerAdapter.EarthquakeViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var earthquakes = Collections.emptyList<Earthquake>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EarthquakeViewHolder {
        val binding: EarthquakeListItemBinding = DataBindingUtil.inflate(inflater, R.layout.earthquake_list_item, parent, false)
        return EarthquakeViewHolder(binding.root)
    }

    override fun getItemCount() = earthquakes.size

    override fun onBindViewHolder(holder: EarthquakeViewHolder, position: Int) {
        holder.binding?.earthquake = earthquakes[position]
        with(holder) {
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
        val binding: EarthquakeListItemBinding? = DataBindingUtil.bind(itemView)
    }

    interface OnItemClickListener {
        fun openMap(position: Int)
    }
}