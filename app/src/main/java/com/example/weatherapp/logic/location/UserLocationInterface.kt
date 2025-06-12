package com.example.weatherapp.logic.location

import android.content.Context
import android.location.Location

interface UserLocationInterface {
    suspend fun getCurrentUserLocation(context: Context): Result<Location?>
    fun getCityName(longitude: Double, latitude: Double, context: Context): Result<String>
}