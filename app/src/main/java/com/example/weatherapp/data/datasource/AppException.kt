package com.example.weatherapp.data.datasource

sealed class AppException: Exception() {
    class LocationPermissionNotGranted(message:String) : AppException()
    class CanNotGetLocationException(message:String) : AppException()
    class CityNameException(message:String) : AppException()
    class WeatherDataException(message:String) : AppException()
}