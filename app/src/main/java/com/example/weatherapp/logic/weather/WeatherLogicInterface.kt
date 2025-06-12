package com.example.weatherapp.logic.weather

import com.example.weatherapp.logic.models.Weather

interface WeatherLogicInterface {
    suspend fun getWeather(latitude: Double, longitude: Double): Result<Weather>
}