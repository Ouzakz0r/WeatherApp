package com.example.gabriel.weatherapp.domain.model

/**
 * Created by Gabriel on 20/08/2017.
 */

data class ForecastList(val city: String, val country: String, val dailyForecast: List<Forecast>){

    operator fun get(position: Int) = dailyForecast[position]
    fun size(): Int = dailyForecast.size



}
data class Forecast(val date: String, val description: String, val high: Int, val low: Int, val iconUrl: String)