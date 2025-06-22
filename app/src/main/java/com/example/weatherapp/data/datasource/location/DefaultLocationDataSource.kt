package com.example.weatherapp.data.datasource.location

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import androidx.core.app.ActivityCompat
import com.example.weatherapp.data.datasource.AppException
import com.example.weatherapp.data.datasource.AppException.CanNotGetLocationException
import com.example.weatherapp.data.datasource.AppException.CityNameException
import com.example.weatherapp.data.datasource.AppException.LocationPermissionNotGranted
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.Priority
import com.google.android.gms.tasks.CancellationTokenSource
import kotlinx.coroutines.tasks.await

class DefaultLocationDataSource(
    val geoCoder: Geocoder, val fusedLocationClient: FusedLocationProviderClient
) : ILocationDataSource {
    override suspend fun getCurrentUserLocation(context: Context): Location {
         try {


             if (ActivityCompat.checkSelfPermission(
                    context, Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    context, Manifest.permission.ACCESS_COARSE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                throw LocationPermissionNotGranted("Permission not granted")
            } else {
                return fusedLocationClient.getCurrentLocation(
                    Priority.PRIORITY_HIGH_ACCURACY, CancellationTokenSource().token
                ).await()  ?: throw CanNotGetLocationException("Can not get location")

            }

        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun getCityName(
        longitude: Double, latitude: Double, context: Context
    ): String {
        try {

            val addresses = geoCoder.getFromLocation(
                latitude, longitude, 3
            )
            if (addresses != null && addresses.isNotEmpty()) {
                var city = addresses[0]
                return city.locality
            } else {
                return "Unknown city"
            }
        } catch (e: Exception) {
            throw CityNameException("Can not get city name")
        }
    }
}