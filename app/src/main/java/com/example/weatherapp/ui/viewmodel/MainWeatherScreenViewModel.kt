package com.example.weatherapp.ui.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.datasource.AppException
import com.example.weatherapp.logic.location.UserLocationInterface
import com.example.weatherapp.logic.weather.WeatherLogicInterface
import com.example.weatherapp.ui.ui_states.WeatherUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainWeatherScreenViewModel(
    val weatherLogicInterface: WeatherLogicInterface, val userLocation: UserLocationInterface
) : ViewModel() {
    private val _state: MutableStateFlow<WeatherUiState> = MutableStateFlow(WeatherUiState.Initial)
    var state: StateFlow<WeatherUiState> = _state

    fun getWeather(context: Context) {
        viewModelScope.launch {
             try {
                 _state.value = WeatherUiState.Loading

                 val location =userLocation.getCurrentUserLocation(context)
                 val cityName = userLocation.getCityName(
                     longitude = location.longitude,
                     latitude = location.latitude,
                     context = context
                 )
                 val weather = weatherLogicInterface.getWeather(latitude = location.latitude, longitude = location.longitude)
                 Log.i("weather", "${weather}")
                 println(weather)
                 _state.update { WeatherUiState.Success(
                     weatherData = weather,
                     location = location,
                     cityName = cityName
                 ) }

            }catch (e: AppException){
//                when(e){
//                    AppException.CanNotGetLocationException -> TODO()
//                    AppException.CityNameException -> TODO()
//                    AppException.LocationPermissionNotGranted -> TODO()
//                }
                _state.update { WeatherUiState.Failure(e.toString()) }
            }


            }

        }
    }


