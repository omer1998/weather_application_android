package com.example.weatherapp.logic.repository

import com.example.weatherapp.logic.models.Weather

interface IWeatherRepository {
    suspend fun getWeather(latitude:Double, longitude:Double): Weather
}