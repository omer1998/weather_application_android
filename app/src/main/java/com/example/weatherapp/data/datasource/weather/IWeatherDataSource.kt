package com.example.weatherapp.data.datasource.weather

interface IWeatherDataSource {
    suspend fun getWeather(latitude:Double, longitude:Double) : WeatherDTO
}