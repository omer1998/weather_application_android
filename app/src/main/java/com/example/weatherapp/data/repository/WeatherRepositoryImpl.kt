package com.example.weatherapp.data.repository

import com.example.weatherapp.data.datasource.weather.IWeatherDataSource
import com.example.weatherapp.data.datasource.weather.toWeather
import com.example.weatherapp.logic.models.Weather
import com.example.weatherapp.logic.repository.IWeatherRepository

class WeatherRepositoryImpl(val IWeatherDataSource: IWeatherDataSource) : IWeatherRepository {
    override suspend fun getWeather(
        latitude: Double, longitude: Double
    ): Weather {
        val weatherDTO = IWeatherDataSource.getWeather(latitude = latitude, longitude = longitude)
        return weatherDTO.toWeather()
    }
}