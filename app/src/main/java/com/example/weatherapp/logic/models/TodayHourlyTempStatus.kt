package com.example.weatherapp.logic.models

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class TodayHourlyTemperatureStatus(
    val date: LocalDateTime,
    val temperature :Float,
    val weatherCode: Int,
    val isDay: Boolean,
    val uvIndex: Float
)

fun TodayHourlyTemperatureStatus.getTime():String{
    return this.date.toLocalTime().toString()
}