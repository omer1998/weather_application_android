package com.example.weatherapp.logic.location

import android.Manifest
import android.content.Context
import android.location.Geocoder
import android.location.Location
import androidx.annotation.RequiresPermission
import com.example.weatherapp.data.datasource.location.ILocationDataSource
import com.example.weatherapp.logic.repository.ILocationRepository
import com.example.weatherapp.logic.repository.IWeatherRepository
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.google.android.gms.tasks.CancellationTokenSource
import kotlinx.coroutines.tasks.await
import java.util.Locale.getDefault


class UserLocation(val locationRepository: ILocationRepository) : UserLocationInterface {


    override suspend fun getCurrentUserLocation(context: Context): Location {
        return locationRepository.getCurrentUserLocation(context = context)

    }

    override suspend fun getCityName(
        longitude: Double, latitude: Double, context: Context
    ): String {
        return locationRepository.getCityName(
            longitude = longitude, latitude = latitude, context = context
        )

    }


}


