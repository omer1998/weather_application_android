package com.example.weatherapp.ui.screens

import android.Manifest
import android.util.Log
import androidx.annotation.RequiresPermission
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.widget.ContentLoadingProgressBar
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.weatherapp.R
import com.example.weatherapp.datasource.MeteoApiDataSource
import com.example.weatherapp.logic.models.dayName
import com.example.weatherapp.logic.models.getTime
import com.example.weatherapp.ui.composables.DayTemperatureInfo
import com.example.weatherapp.ui.composables.SectionTitle
import com.example.weatherapp.ui.composables.SmallWeatherImageView
import com.example.weatherapp.ui.composables.TemperatureInfoCard
import com.example.weatherapp.ui.composables.TemperatureView
import com.example.weatherapp.ui.composables.WeatherImageView
import com.example.weatherapp.ui.composables.WeatherInfoCard
import com.example.weatherapp.ui.ui_models.LocationViewModel
import com.example.weatherapp.ui.ui_models.WeatherUiState
import com.example.weatherapp.ui.viewmodel.MainWeatherScreenViewModel
import com.example.weatherapp.utils.getWeatherImageFromWeatherCode
import com.example.weatherapp.utils.getWeatherStatusFromCode
import com.google.android.gms.location.LocationServices
import io.ktor.http.ContentType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

@Composable
fun MainWeatherScreen(
    modifier: Modifier = Modifier,
    weatherScreenViewModel: MainWeatherScreenViewModel,
    //locationViewModel: LocationViewModel
) {
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        weatherScreenViewModel.getWeather(context)
    }
    val state = weatherScreenViewModel.state.collectAsState()


    Log.i("state", "state now is $state")

    val scrollState = rememberLazyListState()
    val showHeaderSideBySide by remember {
        derivedStateOf { scrollState.firstVisibleItemIndex > 0 }
    }


    val imageSize by animateIntAsState(if (showHeaderSideBySide) 120 else 200)

    val currentStateValue = state.value
    when (currentStateValue) {
        is WeatherUiState.Failure -> {
            Box(Modifier.padding(30.dp)) {
                Text(currentStateValue.error)
            }
        }

        is WeatherUiState.Intitial -> {

        }

        is WeatherUiState.Loading -> {
            LoadingScreen()

        }

        is WeatherUiState.Success -> {
            val currentWeather = currentStateValue.weatherData
            LazyColumn(
                state = scrollState,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.linearGradient(
                            colors = if(currentWeather.isDay) listOf(
                                Color(0xFF87CEFA), Color(0xFFFFFFFF)
                            ) else listOf(Color(0xFF060414), Color(0xFF0D0C19))
                        ),
                    )

            ) {

                item {
                    Spacer(Modifier.height(32.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(R.drawable.location_icon),
                            contentDescription = "location icon"
                        )
                        Spacer(Modifier.width(4.dp))
                        Text(
                            currentStateValue.cityName,
                            fontWeight = FontWeight(500),
                            fontSize = 16.sp,
                            lineHeight = 20.sp,
                            letterSpacing = 0.25.sp,
                        )
                    }
                }
                item {
                    Spacer(Modifier.height(24.dp))

                }
                item {
//

                    Crossfade(showHeaderSideBySide) {
                        when (it) {
                            true -> {
                                Row(
                                    Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    SmallWeatherImageView(weatherCode = currentWeather.weatherCode) // getImageFromWeatherCode
                                    TemperatureView(
                                        currentTemp = currentWeather.currentTemperature,
                                        weatherStatus = getWeatherStatusFromCode(currentWeather.weatherCode), // getWeatherStatusFromCode()
                                        maxTemp = currentWeather.highTemperature,
                                        minTemp = currentWeather.lowTemperature
                                    )
                                }
                            }

                            else -> {
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    WeatherImageView()
                                    TemperatureView(
                                        currentTemp = currentWeather.currentTemperature,
                                        weatherStatus = getWeatherStatusFromCode(currentWeather.weatherCode), // getWeatherStatusFromCode()
                                        maxTemp = currentWeather.highTemperature,
                                        minTemp = currentWeather.lowTemperature
                                    )
                                }

                            }
                        }
                    }
                }


                item {
                    Spacer(Modifier.height(24.dp))
                }
                item {
                    Column(
                        Modifier
                            .padding(horizontal = 12.dp)
                            .fillMaxWidth()
                    ) {

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            WeatherInfoCard(
                                modifier = Modifier.weight(1f),
                                icon = painterResource(R.drawable.wind_icon),
                                title = "Wind",
                                data = "${currentWeather.windSpeed} KM/h",
                            )
                            WeatherInfoCard(
                                modifier = Modifier.weight(1f),

                                icon = painterResource(R.drawable.humidity_icon),
                                title = "Humidity",
                                data = "${currentWeather.humidity} %",
                            )
                            WeatherInfoCard(
                                modifier = Modifier.weight(1f),
                                icon = painterResource(R.drawable.rain_icon),
                                title = "Rain",
                                data = "${currentWeather.rain} %",
                            )
                        }
                        Spacer(Modifier.height(6.dp))
                        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                            WeatherInfoCard(
                                modifier = Modifier.weight(1f),
                                icon = painterResource(R.drawable.uv_index_icon),
                                title = "UV index",
                                data = "${currentWeather.uvIndex}",
                            )
                            WeatherInfoCard(
                                modifier = Modifier.weight(1f),
                                icon = painterResource(R.drawable.pressure_icon),
                                title = "Pressure",
                                data = "${currentWeather.pressure} hPa",
                            )
                            WeatherInfoCard(
                                modifier = Modifier.weight(1f),
                                icon = painterResource(R.drawable.temperature_icon),
                                title = "Feels like",
                                data = "${currentWeather.currentTemperature}°C",
                            )
                        }
                    }

                }
                item {
                    Spacer(Modifier.height(24.dp))
                    SectionTitle("Today", modifier = Modifier.padding(horizontal = 12.dp))
                    Spacer(Modifier.height(12.dp))
                }
                item {
                    LazyRow(
                        contentPadding = PaddingValues(horizontal = 12.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(
                            items = currentWeather.todayHourlyTemperature,
                            key = { it.time }) { it ->
                            TemperatureInfoCard(
                                image = painterResource(getWeatherImageFromWeatherCode(it.weatherCode, currentWeather.isDay)),
                                temperature = it.temperature,
                                time = it.getTime(),
                            )
                        }
                    }
                }

                item {
                    Spacer(Modifier.height(24.dp))
                    SectionTitle("Next 7 Days", modifier = Modifier.padding(horizontal = 12.dp))
                    Spacer(Modifier.height(12.dp))
                }
                item {
                    Box(
                        Modifier
                            .padding(start = 12.dp, end = 12.dp, bottom = 32.dp)
                            .background(Color.White, RoundedCornerShape(24.dp))
                            .clip(androidx.compose.foundation.shape.RoundedCornerShape(24.dp))
                            .border(1.dp, color = Color(0x14060414)),

                        ) {
                        Column {
                            currentWeather.nextSeverDaysDetails.forEach {
                                DayTemperatureInfo(
                                    day = it.dayName(),
                                    image = painterResource(getWeatherImageFromWeatherCode(it.weatherCode, currentWeather.isDay)),
                                    highTemp = it.maxTemp,
                                    lowTemp = it.minTemp,

                                    )
                            }
//
                        }

                    }
                }


            }
        }

    }

}

@Preview
@Composable
private fun PreviewMainWeatherScreen() {
    //MainWeatherScreen()
}