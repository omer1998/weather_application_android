package com.example.weatherapp.di

import com.example.weatherapp.datasource.MeteoApiDataSource
import com.example.weatherapp.datasource.WeatherDataSource
import com.example.weatherapp.logic.location.UserLocation
import com.example.weatherapp.logic.location.UserLocationInterface
import com.example.weatherapp.logic.weather.WeatherLogicImpl
import com.example.weatherapp.logic.weather.WeatherLogicInterface
import com.example.weatherapp.ui.ui_models.LocationViewModel
import com.example.weatherapp.ui.viewmodel.MainWeatherScreenViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule: Module = module {

    single<UserLocationInterface> {
        UserLocation()
    }
    single<WeatherDataSource> {
        MeteoApiDataSource()
    }
    single<WeatherLogicInterface> {
        WeatherLogicImpl(get())
    }
    viewModel {
        MainWeatherScreenViewModel(get(),get())
    }
    viewModel {
        LocationViewModel(get())
    }
}