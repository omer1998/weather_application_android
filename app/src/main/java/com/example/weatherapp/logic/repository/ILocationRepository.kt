package com.example.weatherapp.logic.repository

import android.content.Context
import android.location.Location

interface ILocationRepository {
    suspend fun getCurrentUserLocation(context: Context): Location
    suspend fun getCityName(longitude: Double, latitude: Double, context: Context): String

}