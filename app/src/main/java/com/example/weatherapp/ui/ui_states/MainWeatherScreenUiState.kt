package com.example.weatherapp.ui.ui_states

import android.location.Location
import com.example.weatherapp.logic.models.Weather

// ==> can i use the weather model (which is app entity) here for ui state  ??
// or should i create a new model with each field of the weather model
sealed class WeatherUiState {
    object Initial : WeatherUiState()
    object Loading : WeatherUiState()
    data class Success(val weatherData: Weather, val location: Location?, val cityName: String) :
        WeatherUiState()

    data class Failure(val error: String) : WeatherUiState()
}