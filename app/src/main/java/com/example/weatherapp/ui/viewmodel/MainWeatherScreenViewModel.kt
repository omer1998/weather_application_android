package com.example.weatherapp.ui.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.logic.location.UserLocationInterface
import com.example.weatherapp.logic.weather.WeatherLogicInterface
import com.example.weatherapp.ui.ui_models.WeatherUiState
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainWeatherScreenViewModel(
    val weatherLogicInterface: WeatherLogicInterface,
    val userLocation: UserLocationInterface
) : ViewModel() {
    private val _state: MutableStateFlow<WeatherUiState> = MutableStateFlow(WeatherUiState.Intitial)
    var state: StateFlow<WeatherUiState> = _state
//    init {
//        viewModelScope.launch {
//            _state.value = state.value.copy(isLoading = true)
//           val result =  weatherLogicInterface.getWeather()
//
//            result.fold(
//                onFailure = { t->
//                    _state.value = state.value.copy(isLoading = false)
//                    _state.value = state.value.copy(error = t.toString())
//
//                },
//                onSuccess = { weatherData ->
//                    _state.value = state.value.copy(isLoading = false)
//                    _state.value = state.value.copy(weatherContent = weatherData)
//
//                }
//            )
//
//
//        }
//    }.


    fun getWeather(context: Context) {
        viewModelScope.launch {
            _state.value = WeatherUiState.Loading
            val locationResult = userLocation.getCurrentUserLocation(context)
            locationResult.fold(
                onSuccess = { location ->
                    Log.i("locationnnnnn", "$location")
                    if (location != null){
                        val cityNameDeffered = async {
                            userLocation.getCityName(
                                context = context,
                                latitude = location.latitude,
                                longitude = location.longitude,

                            )
                        }
                        cityNameDeffered.await().fold(
                            onSuccess = { cityName ->
                                val result = weatherLogicInterface.getWeather(
                                    latitude= location.latitude, longitude = location.longitude
                                )

                                result.fold(onFailure = { t ->
                                    println("===> failure ${t.message}")
                                    _state.value = WeatherUiState.Failure(t.message.toString())

                                }, onSuccess = { weatherData ->
                                    println("===> Success ${weatherData.toString()}")

                                    _state.value = WeatherUiState.Success(weatherData, location, cityName)
                                })
                            },
                             onFailure = {
                                 _state.value = WeatherUiState.Failure(it.message.toString())

                             }
                        )

                    }else {
                        _state.value = WeatherUiState.Failure("Location not available")

                    }

                },
                onFailure = {
                    _state.value = WeatherUiState.Failure(it.message.toString())

                }
            )


        }
    }

}
