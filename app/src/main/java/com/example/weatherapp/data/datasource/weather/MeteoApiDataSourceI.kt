package com.example.weatherapp.data.datasource

import io.ktor.client.*
import io.ktor.client.call.body
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import kotlinx.serialization.json.Json


class MeteoApiDataSource : WeatherDataSource {

    val client = HttpClient(CIO) {
        install(ContentNegotiation)
    }

    val json = Json {
        prettyPrint = true
        isLenient = true
        ignoreUnknownKeys = true
    }

    override suspend fun getWeather(latitude: Double, longitude: Double): WeatherDTO {
        val url =
           // "https://api.open-meteo.com/v1/forecast?latitude=${latitude}&longitude=${longitude}&daily=weather_code,temperature_2m_max,temperature_2m_min,uv_index_max&hourly=temperature_2m,weather_code,is_day&current=temperature_2m,relative_humidity_2m,rain,showers,snowfall,weather_code,pressure_msl,wind_speed_10m,is_day"
        "https://api.open-meteo.com/v1/forecast?latitude=${latitude}&longitude=${longitude}&daily=weather_code,temperature_2m_max,temperature_2m_min,uv_index_max&hourly=temperature_2m,weather_code,is_day,uv_index&current=temperature_2m,relative_humidity_2m,rain,showers,snowfall,weather_code,pressure_msl,wind_speed_10m,is_day&timezone=auto&forecast_hours=24"
        val response = client.get(
            url
        )
        val weatherDto = json.decodeFromString<WeatherDTO>(response.body())


        return weatherDto

    }
}