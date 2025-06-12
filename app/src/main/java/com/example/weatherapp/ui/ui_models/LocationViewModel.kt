package com.example.weatherapp.ui.ui_models

import android.content.Context
import android.location.Location
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.logic.location.UserLocation
import com.example.weatherapp.logic.location.UserLocationInterface
import kotlinx.coroutines.launch

//
//class Location(
//    val longitude: Float, val latitude: Float
//)

class LocationViewModel(val userLocation: UserLocationInterface): ViewModel() {
    private val _locationState = mutableStateOf<Location?>(null)
    val locationState = _locationState

    fun fetchUserLocation(context: Context) {
//        viewModelScope.launch {
//            val location = userLocation.getCurrentUserLocation(context)
//            _locationState.value = location
//            Log.i("location#", "$location")
//        }
    }
}

