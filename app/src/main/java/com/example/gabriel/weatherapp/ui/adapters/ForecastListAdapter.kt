package com.example.gabriel.weatherapp.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.gabriel.weatherapp.R
import com.example.gabriel.weatherapp.domain.model.Forecast
import com.example.gabriel.weatherapp.domain.model.ForecastList
import com.example.gabriel.weatherapp.ui.utils.ctx
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_forecast.view.*
import org.jetbrains.anko.find

/**
 * Created by Gabriel on 20/07/2017.
 */

class ForecastListAdapter(val weekForecast: ForecastList,
                          val itemClick: (Forecast) -> Unit) :
        RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.ctx).inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(weekForecast[position])
    }

    override fun getItemCount(): Int = weekForecast.size()

    class ViewHolder(view: View,
                     val itemClick: (Forecast) -> Unit) : RecyclerView.ViewHolder(view) {

        //Tudo que está comentado foi possível enxugar graças ao Android Extensions
       // private val iconView = view.find<ImageView>(R.id.icon)
       // private val dateView = view.find<TextView>(R.id.date)
       // private val descriptionView = view.find<TextView>(R.id.description)
       // private val maxTemperatureView = view.find<TextView>(R.id.maxTemperature)
       // private val minTemperatureView = view.find<TextView>(R.id.minTemperature)

        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Picasso.with(itemView.ctx).load(iconUrl).into(itemView.icon)
                itemView.date.text = date
                itemView.description.text = description
                itemView.maxTemperature.text = "$high"
                itemView.minTemperature.text = "$low"
                itemView.setOnClickListener { itemClick(this) }
                //dateView.text = date
                //descriptionView.text = description
                //maxTemperatureView.text = "${high}º"
                //minTemperatureView.text = "${low}º"

            }
        }
    }

}

