package com.example.weatherapp.di

import android.location.Geocoder
import com.example.weatherapp.data.datasource.MeteoApiDataSource
import com.example.weatherapp.data.datasource.WeatherDataSource
import com.example.weatherapp.data.repository.WeatherRepositoryImpl
import com.example.weatherapp.logic.location.UserLocation
import com.example.weatherapp.logic.location.UserLocationInterface
import com.example.weatherapp.logic.repository.IWeatherRepository
import com.example.weatherapp.logic.weather.WeatherLogicImpl
import com.example.weatherapp.logic.weather.WeatherLogicInterface
import com.example.weatherapp.ui.viewmodel.MainWeatherScreenViewModel
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import java.util.Locale.getDefault

val appModule: Module = module {
    single<WeatherDataSource> {
        MeteoApiDataSource()
    }
    single<IWeatherRepository> {
        WeatherRepositoryImpl(get())
    }
    single<Geocoder> {
        Geocoder(androidContext(), getDefault())
    }
    single<FusedLocationProviderClient> {
        LocationServices.getFusedLocationProviderClient(androidContext())

    }
    single<UserLocationInterface> {
        UserLocation(get(), get())
    }

    single<WeatherLogicInterface> {
        WeatherLogicImpl(get())
    }
    viewModel {
        MainWeatherScreenViewModel(get(), get())
    }
    viewModel {
        LocationViewModel(get())
    }
}