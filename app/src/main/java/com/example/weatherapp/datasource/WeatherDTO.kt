package com.example.weatherapp.datasource

import com.example.weatherapp.logic.models.DayTemperatureStatus
import com.example.weatherapp.logic.models.TodayHourlyTemperatureStatus
import com.example.weatherapp.logic.models.Weather
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherDTO(val current: Current, val daily: Daily, val hourly: Hourly)

fun WeatherDTO.toWeather(): Weather{
    val dictTemp = mutableMapOf<String, Pair<Float, Int>>()

    val next7DaysDetails = mutableListOf<DayTemperatureStatus>()
    daily.date.forEachIndexed { index, date ->
        next7DaysDetails.add(DayTemperatureStatus(
            date = date,
            weatherCode = daily.weatherCode[index],
            maxTemp = daily.temperatureMax[index],
            minTemp = daily.temperatureMin[index]
        ))

    }
    val hourlyTemperatures = mutableListOf<TodayHourlyTemperatureStatus>()
    hourly.time.forEachIndexed { index, time->
        hourlyTemperatures.add(
            TodayHourlyTemperatureStatus(
                time = time,
                temperature = hourly.temperature[index],
                weatherCode = hourly.weatherCode[index]
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
        uvIndex = daily.maxUvIndex[0],
        windSpeed = current.windSpeed,
        weatherCode = current.weatherCode,
        nextSeverDaysDetails = next7DaysDetails,
        todayHourlyTemperature = hourlyTemperatures
    )
}
@Serializable
data class Hourly(
    val time: List<String>,
    @SerialName("temperature_2m")
    val temperature: List<Float>,
    @SerialName("weather_code")
    val weatherCode: List<Int>
)

@Serializable
data class Daily(
    @SerialName("time")
    val date: List<String>,
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