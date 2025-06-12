package com.example.weatherapp.logic.models

data class Weather(
    val currentTemperature: Float,
    val highTemperature: Float,
    val lowTemperature: Float,
    val humidity: Float,
    val rain: Float,
    val pressure: Float,
    val uvIndex: Float,
    val windSpeed: Float,
    val weatherCode: Int,
    val todayHourlyTemperature: List<TodayHourlyTemperatureStatus>,
    val nextSeverDaysDetails : List<DayTemperatureStatus>

    )