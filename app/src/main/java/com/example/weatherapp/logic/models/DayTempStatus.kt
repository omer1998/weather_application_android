package com.example.weatherapp.logic.models

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

class DayTemperatureStatus(
    val date: String,
    val weatherCode:Int,
    val maxTemp: Float,
    val minTemp: Float
)

fun DayTemperatureStatus.dayName():String{
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.getDefault())
    val date = LocalDate.parse(this.date,formatter)
    return date.dayOfWeek.toString().lowercase().replaceFirstChar { it.uppercase() }

}
