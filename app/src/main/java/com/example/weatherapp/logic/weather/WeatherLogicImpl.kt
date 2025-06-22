package com.example.weatherapp.logic.weather

import com.example.weatherapp.data.datasource.AppException
import com.example.weatherapp.data.datasource.AppException.WeatherDataException
import com.example.weatherapp.logic.models.Weather
import com.example.weatherapp.logic.repository.IWeatherRepository

class WeatherLogicImpl(val weatherRepository: IWeatherRepository) : WeatherLogicInterface {
    override suspend fun getWeather(latitude: Double, longitude: Double): Weather {
        try {
            val weatherData = weatherRepository.getWeather(latitude, longitude)
            return weatherData
        } catch (e: Exception) {
            throw WeatherDataException("Problem with getting weather data, ${e.message}")
        }
    }
}