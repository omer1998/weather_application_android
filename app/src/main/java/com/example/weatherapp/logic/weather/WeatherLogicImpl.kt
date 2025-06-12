package com.example.weatherapp.logic.weather

import com.example.weatherapp.data.datasource.WeatherDataSource
import com.example.weatherapp.data.datasource.toWeather
import com.example.weatherapp.logic.models.Weather

class WeatherLogicImpl(val weatherDatasource: WeatherDataSource): WeatherLogicInterface {
    override suspend fun getWeather(latitude: Double, longitude: Double): Result<Weather> {
        try {
            val weatherData = weatherDatasource.getWeather(latitude,longitude).toWeather()
            return Result.success(weatherData)
        }catch(e: Exception){
            return Result.failure(e)
        }
    }
}