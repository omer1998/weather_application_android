package com.example.weatherapp.data.datasource

import com.example.weatherapp.logic.models.DayTemperatureStatus
import com.example.weatherapp.logic.models.TodayHourlyTemperatureStatus
import com.example.weatherapp.logic.models.Weather
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

@Serializable
data class WeatherDTO(val current: Current, val daily: Daily, val hourly: Hourly)

fun WeatherDTO.toWeather(): Weather {

    val next7DaysDetails = mutableListOf<DayTemperatureStatus>()
    daily.date.forEachIndexed { index, date ->
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.getDefault())
         val localDate = LocalDate.parse(date,formatter)

        next7DaysDetails.add(
            DayTemperatureStatus(
                date = localDate,
                weatherCode = daily.weatherCode[index],
                maxTemp = daily.temperatureMax[index],
                minTemp = daily.temperatureMin[index]
            )
        )

    }
    val hourlyTemperatures = mutableListOf<TodayHourlyTemperatureStatus>()
    hourly.time.forEachIndexed { index, date ->
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")
        val localDateTime = LocalDateTime.parse(date, formatter)
        hourlyTemperatures.add(
            TodayHourlyTemperatureStatus(
                date = localDateTime, //"2025-06-12T00:00"
                temperature = hourly.temperature[index],
                weatherCode = hourly.weatherCode[index],
                isDay = hourly.isDay[index] == 1,
                uvIndex = hourly.uvIndex[index]
            )
        )
    }

    return Weather(
        currentTemperature = current.temperature,
        highTemperature = daily.temperatureMax[0],
        lowTemperature = daily.temperatureMin[0],
        humidity = current.humidity,
        rain = current.rain,
        pressure = current.pressure,
        uvIndex = hourly.uvIndex[0],
        windSpeed = current.windSpeed,
        weatherCode = current.weatherCode,
        nextSeverDaysDetails = next7DaysDetails,
        todayHourlyTemperature = hourlyTemperatures,
        isDay = current.isDay == 1
    )
}

@Serializable
data class Hourly(
    val time: List<String>,
    @SerialName("temperature_2m") val temperature: List<Float>,
    @SerialName("weather_code") val weatherCode: List<Int>,
    @SerialName("is_day") val isDay: List<Int>,
    @SerialName("uv_index") val uvIndex: List<Float>
)

@Serializable
data class Daily(
    @SerialName("time") val date: List<String>,
    @SerialName("weather_code") val weatherCode: List<Int>,
    @SerialName("temperature_2m_max") val temperatureMax: List<Float>,
    @SerialName("temperature_2m_min") val temperatureMin: List<Float>,
    @SerialName("uv_index_max") val maxUvIndex: List<Float>

)

@Serializable
data class Current(
    val time: String,
    @SerialName("temperature_2m") val temperature: Float,
    @SerialName("relative_humidity_2m") val humidity: Float,
    val rain: Float,
    val showers: Float,
    val snowfall: Float,
    @SerialName("weather_code") val weatherCode: Int,
    @SerialName("pressure_msl") val pressure: Float,
    @SerialName("wind_speed_10m") val windSpeed: Float,
    @SerialName("is_day") val isDay: Int

)