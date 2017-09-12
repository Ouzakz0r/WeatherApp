package com.example.gabriel.weatherapp.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.gabriel.weatherapp.ui.adapters.ForecastListAdapter
import com.example.gabriel.weatherapp.R
import com.example.gabriel.weatherapp.domain.commands.RequestForecastCommand
import com.example.gabriel.weatherapp.domain.model.Forecast
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //não é necessária a declaração pois o Android Extension cuida disso pra vc
       // val forecastList : RecyclerView = find(R.id.forecast_list)
        forecastlist.layoutManager = LinearLayoutManager(this)

        doAsync {
            val result = RequestForecastCommand("94043").execute()
            uiThread {
                val adapter = ForecastListAdapter(result) { toast(it.date) }
                forecastlist.adapter = adapter
            }
        }
    }
}
