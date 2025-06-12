package com.example.weatherapp.di

import com.example.weatherapp.data.datasource.MeteoApiDataSource
import com.example.weatherapp.data.datasource.WeatherDataSource
import com.example.weatherapp.data.repository.WeatherRepositoryImpl
import com.example.weatherapp.logic.location.UserLocation
import com.example.weatherapp.logic.location.UserLocationInterface
import com.example.weatherapp.logic.repository.IWeatherRepository
import com.example.weatherapp.logic.weather.WeatherLogicImpl
import com.example.weatherapp.logic.weather.WeatherLogicInterface
import com.example.weatherapp.ui.ui_models.LocationViewModel
import com.example.weatherapp.ui.viewmodel.MainWeatherScreenViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule: Module = module {
    single<WeatherDataSource> {
        MeteoApiDataSource()
    }
    single<IWeatherRepository> {
        WeatherRepositoryImpl(get())
    }
    single<UserLocationInterface> {
        UserLocation()
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