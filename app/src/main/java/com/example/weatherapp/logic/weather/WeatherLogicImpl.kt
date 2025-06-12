package com.example.weatherapp.logic.weather

import com.example.weatherapp.data.datasource.WeatherDataSource
import com.example.weatherapp.data.datasource.toWeather
import com.example.weatherapp.data.repository.WeatherRepositoryImpl
import com.example.weatherapp.logic.models.Weather
import com.example.weatherapp.logic.repository.IWeatherRepository

class WeatherLogicImpl(val weatherRepository: IWeatherRepository): WeatherLogicInterface {
    override suspend fun getWeather(latitude: Double, longitude: Double): Result<Weather> {
        try {
            val weatherData = weatherRepository.getWeather(latitude,longitude)
            return Result.success(weatherData)
        }catch(e: Exception){
            return Result.failure(e)
        }
    }
}