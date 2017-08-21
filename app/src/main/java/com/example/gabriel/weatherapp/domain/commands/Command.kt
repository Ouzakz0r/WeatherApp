package com.example.gabriel.weatherapp.domain.commands

/**
 * Created by Gabriel on 20/08/2017.
 */

interface Command<out T>{
    fun execute(): T
}