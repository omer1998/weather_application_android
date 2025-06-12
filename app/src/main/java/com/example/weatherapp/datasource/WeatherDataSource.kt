package com.example.weatherapp.datasource

interface WeatherDataSource {
    suspend fun getWeather(latitude:Double, longitude:Double) : WeatherDTO
}