package com.example.weatherapp.data.datasource.location

import android.content.Context
import android.location.Location

interface ILocationDataSource {
    suspend fun getCurrentUserLocation(context: Context): Location
    suspend fun getCityName(longitude: Double, latitude: Double, context: Context): String

}