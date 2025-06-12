package com.example.weatherapp.logic.models

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class TodayHourlyTemperatureStatus(
    val time: String,
    val temperature :Float,
    val weatherCode: Int,
    val isDay: Boolean
)

fun TodayHourlyTemperatureStatus.getTime():String{
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")
    val localDateTime = LocalDateTime.parse(this.time, formatter)
    return localDateTime.toLocalTime().toString()
}