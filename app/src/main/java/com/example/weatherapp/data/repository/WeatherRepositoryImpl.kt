package com.example.weatherapp.data.repository

import com.example.weatherapp.data.datasource.WeatherDataSource
import com.example.weatherapp.data.datasource.toWeather
import com.example.weatherapp.logic.models.Weather
import com.example.weatherapp.logic.repository.IWeatherRepository

class WeatherRepositoryImpl(val weatherDataSource: WeatherDataSource) : IWeatherRepository {
    override suspend fun getWeather(
        latitude: Double, longitude: Double
    ): Weather {
        val weatherDTO = weatherDataSource.getWeather(latitude = latitude, longitude = longitude)
        return weatherDTO.toWeather()
    }
}