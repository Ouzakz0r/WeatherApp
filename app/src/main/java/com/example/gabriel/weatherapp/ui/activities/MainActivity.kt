package com.example.gabriel.weatherapp.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.gabriel.weatherapp.ui.adapters.ForecastListAdapter
import com.example.gabriel.weatherapp.R
import com.example.gabriel.weatherapp.domain.commands.RequestForecastCommand
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val forecasList : RecyclerView = find(R.id.forecast_list)
        forecasList.layoutManager = LinearLayoutManager(this)

        doAsync() {
            val result = RequestForecastCommand("94043").execute()
            uiThread {
                forecasList.adapter = ForecastListAdapter(result)
            }
        }
    }
}
