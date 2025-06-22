package com.example.weatherapp

import android.Manifest
import android.app.Application
import android.location.Location
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresPermission
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.weatherapp.di.appModule
import com.example.weatherapp.logic.location.UserLocation
import com.example.weatherapp.ui.screens.MainWeatherScreen
import com.example.weatherapp.ui.theme.WeatherAppTheme
import com.example.weatherapp.ui.viewmodel.MainWeatherScreenViewModel
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.google.android.gms.tasks.CancellationToken
import com.google.android.gms.tasks.CancellationTokenSource
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.startKoin

class MainActivity : ComponentActivity() {


    @OptIn(ExperimentalPermissionsApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        val weatherScreenViewModel: MainWeatherScreenViewModel by viewModel()

        enableEdgeToEdge()
        setContent {
            WeatherAppTheme {
                val permissionState = rememberMultiplePermissionsState(
                    listOf(
                        android.Manifest.permission.ACCESS_FINE_LOCATION,
                        android.Manifest.permission.ACCESS_COARSE_LOCATION
                    )
                )
                LaunchedEffect(Unit) {
                    permissionState.launchMultiplePermissionRequest()
                }
                if (permissionState.allPermissionsGranted) {
                    MainWeatherScreen(
                        weatherScreenViewModel = weatherScreenViewModel,
                        //    locationViewModel = locationViewModel
                    )
                } else {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text("permission is not granted")
                    }
                }
            }
        }
    }
}