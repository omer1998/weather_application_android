package com.example.weatherapp.logic.location

import android.Manifest
import android.content.Context
import android.location.Geocoder
import android.location.Location
import androidx.annotation.RequiresPermission
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.google.android.gms.tasks.CancellationTokenSource
import kotlinx.coroutines.tasks.await
import java.util.Locale.getDefault


class UserLocation(val geoCoder: Geocoder, val fusedLocationClient: FusedLocationProviderClient) :
    UserLocationInterface {

    @RequiresPermission(allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])

    override suspend fun getCurrentUserLocation(context: Context): Result<Location?> {

        try {
            val location = fusedLocationClient.getCurrentLocation(
                Priority.PRIORITY_HIGH_ACCURACY, CancellationTokenSource().token
            ).await()

            return Result.success(location)

        } catch (e: Exception) {
            return Result.failure(e)
        }
    }

    override fun getCityName(
        longitude: Double, latitude: Double, context: Context
    ): Result<String> {
        try {

            val addresses = geoCoder.getFromLocation(
                latitude, longitude, 3
            )
            if (addresses != null && addresses.isNotEmpty()) {
                var city = addresses[0]
                return Result.success(city.locality)
            } else {
                return Result.success("Unknown city")
            }
        } catch (e: Exception) {
            return Result.failure(e)
        }

    }


}


