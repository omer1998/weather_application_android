package com.example.weatherapp.ui.ui_models

import android.location.Location
import com.example.weatherapp.logic.models.Weather

//data class MainWeatherScreenUiState(
//    var isLoading: Boolean = false,
//    var error : String? = null,
//    var weatherContent: Weather = Weather(
//        currentTemperature = 0f,
//        highTemperature = 0f,
//        lowTemperature = 0f,
//        humidity = 0f,
//        rain = 0f,
//        pressure = 0f,
//        uvIndex = 0f,
//        windSpeed = 0f,
//        weatherCode = 0
//    )
//
//)

sealed class WeatherUiState {
    object Intitial : WeatherUiState()
    object Loading : WeatherUiState()
    data class Success(val weatherData: Weather, val location: Location?, val cityName: String) :
        WeatherUiState()

    data class Failure(val error: String) : WeatherUiState()
}