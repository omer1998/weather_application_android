package com.example.weatherapp.data.datasource

interface WeatherDataSource {
    suspend fun getWeather(latitude:Double, longitude:Double) : WeatherDTO
}