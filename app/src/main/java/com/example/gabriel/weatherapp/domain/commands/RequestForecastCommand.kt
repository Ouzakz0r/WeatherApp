package com.example.gabriel.weatherapp.domain.commands

import com.example.gabriel.weatherapp.data.ForecastRequest
import com.example.gabriel.weatherapp.domain.mappers.ForecastDataMapper
import com.example.gabriel.weatherapp.domain.model.ForecastList

/**
 * Created by Gabriel on 20/08/2017.
 */

class RequestForecastCommand(val zipCode: String): Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }
}