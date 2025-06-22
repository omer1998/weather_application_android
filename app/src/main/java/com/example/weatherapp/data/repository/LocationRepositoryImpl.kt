package com.example.weatherapp.data.repository

import android.content.Context
import android.location.Location
import com.example.weatherapp.data.datasource.location.DefaultLocationDataSource
import com.example.weatherapp.data.datasource.location.ILocationDataSource
import com.example.weatherapp.logic.repository.ILocationRepository

class LocationRepositoryImpl(val locationDataSource: ILocationDataSource) : ILocationRepository {
    override suspend fun getCurrentUserLocation(context: Context): Location {
        return locationDataSource.getCurrentUserLocation(context)
    }

    override suspend fun getCityName(
        longitude: Double, latitude: Double, context: Context
    ): String {
        return locationDataSource.getCityName(
            longitude = longitude, latitude = latitude, context = context
        )
    }
}