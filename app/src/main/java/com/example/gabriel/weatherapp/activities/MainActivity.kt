package com.example.gabriel.weatherapp.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.gabriel.weatherapp.adapters.ForecastListAdapter
import com.example.gabriel.weatherapp.R
import org.jetbrains.anko.find

class MainActivity : AppCompatActivity() {

    private val items = listOf (
            "Mon 6/23 - Sunny - 31/17" ,
            "Tue 6/24 - Foggy - 21/8" ,
            "Wed 6/25 - Cloudy - 22/17" ,
            "Thurs 6/26 - Rainy - 18/11" ,
            "Fri 6/27 - Foggy - 21/10" ,
            "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18" ,
            "Sun 6/29 - Sunny - 20/7"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val forecasList = findViewById(R.id.forecast_list) as RecyclerView
        //mesma coisa acima utilizando Anko
        val forecasList : RecyclerView = find(R.id.forecast_list)
        forecasList.layoutManager = LinearLayoutManager(this)
        forecasList.adapter = ForecastListAdapter(items)
    }
}
