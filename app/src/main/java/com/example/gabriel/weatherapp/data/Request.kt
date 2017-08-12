package com.example.gabriel.weatherapp.data

import android.util.Log
import java.net.URL

/**
 * Created by Gabriel on 12/08/2017.
 */

class Request(val url: String){

    fun run(){
        val forecastJsonStr = URL(url).readText()
        Log.d(javaClass.simpleName, forecastJsonStr)
    }
}