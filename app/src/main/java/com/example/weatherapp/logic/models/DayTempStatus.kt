package com.example.weatherapp.logic.models

import java.time.LocalDate

class DayTemperatureStatus(
    val date: LocalDate,
    val weatherCode:Int,
    val maxTemp: Float,
    val minTemp: Float
)

fun DayTemperatureStatus.dayName():String{
    return date.dayOfWeek.toString().lowercase().replaceFirstChar { it.uppercase() }

}

