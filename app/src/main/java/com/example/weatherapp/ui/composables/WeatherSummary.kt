package com.example.weatherapp.ui.composables

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.compose.ui.unit.min
import com.example.weatherapp.logic.models.Weather
import com.example.weatherapp.utils.getWeatherStatusFromCode

@Composable
fun WeatherSummary(
    scrollState: ScrollState, currentWeather: Weather, modifier: Modifier = Modifier
) {

    val density = LocalDensity.current
    val scrollStateDp = with(density) { scrollState.value.dp }
    val state = kotlin.math.min(scrollStateDp.value / 212, 1f)
    val screenWidth = LocalConfiguration.current.screenWidthDp

    var imageWidthDp by remember {
        mutableStateOf(0.dp)
    }
    var temperatureInfoWidthDp by remember { mutableStateOf(0.dp) }
    Box(
        modifier = modifier.fillMaxWidth(),
    ) {
        WeatherImageView(
            weatherCode = currentWeather.weatherCode,
            isDay = currentWeather.isDay,
            modifier = Modifier
                .height(lerp(200.dp, 112.dp, state))
                .width(lerp(200.dp, 112.dp, state))
                .onGloballyPositioned { coordinates ->
                    imageWidthDp = with(density) { coordinates.size.width.toDp() }
                }
                .padding(top = lerp(0.dp, 15.5.dp, state))
                .offset(
                    x = lerp(
                        ((screenWidth - imageWidthDp.value) / 2).dp,
                        12.dp, state
                    )
                ),
            contentscale = ContentScale.FillBounds)
        TemperatureView(
            currentTemp = currentWeather.currentTemperature,
            weatherStatus = getWeatherStatusFromCode(currentWeather.weatherCode), // getWeatherStatusFromCode()
            maxTemp = currentWeather.highTemperature,
            minTemp = currentWeather.lowTemperature,
            isDay = currentWeather.isDay,
            modifier = Modifier
                .padding(top = lerp(212.dp, 0.dp, state))
                .onGloballyPositioned { coordinates ->
                    temperatureInfoWidthDp = with(density) { coordinates.size.width.toDp() }
                }
                .offset(
                    x = lerp(
                        ((screenWidth - temperatureInfoWidthDp.value) / 2).dp,
                        (screenWidth - temperatureInfoWidthDp.value - 12).dp,
                        state
                    )

                ))
    }
}

