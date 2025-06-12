package com.example.weatherapp.logic.models

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class TodayHourlyTemperatureStatus(
    val date: LocalDateTime,
    val temperature :Float,
    val weatherCode: Int,
    val isDay: Boolean
)

fun TodayHourlyTemperatureStatus.getTime():String{
    return this.date.toLocalTime().toString()
}