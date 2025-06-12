package com.example.weatherapp.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.example.weatherapp.R
fun getWeatherImageFromWeatherCode(code:Int): Int{
    return when (code) {
        0 -> R.drawable.clear_sky_image
        1 -> R.drawable.mainly_clear
        2 -> R.drawable.partly_cloudy
        3 -> R.drawable.overcast
        45 -> R.drawable.fog
        48 -> R.drawable.depositing_rime_fog
        51 -> R.drawable.drizzle_light
        53 -> R.drawable.drizzle_moderate
        55 -> R.drawable.drizzle_intensity
        56 -> R.drawable.freezing_drizzle_light
        57 -> R.drawable.freezing_drizzle_intensity
        61 -> R.drawable.rain_slight
        63 -> R.drawable.rain_moderate
        65 -> R.drawable.rain_heavy
        66 -> R.drawable.freezing_light
        67 -> R.drawable.freezing_heavy
        71 -> R.drawable.snow_fall_light
        73 -> R.drawable.snow_fall_moderate
        75 -> R.drawable.snow_fall_heavy
        77 -> R.drawable.snow_grains
        80 -> R.drawable.rain_shower_slight
        81 -> R.drawable.rain_shower_moderate
        82 -> R.drawable.rain_shower_violent
        85 -> R.drawable.snow_shower_slight
        86 -> R.drawable.snow_shower_heavy
        95 -> R.drawable.thunderstrom_slight_moderate
        96 -> R.drawable.thunderstrom_with_slight_hail
        99 -> R.drawable.thunderstrom_with_heavy_hail
        else -> R.drawable.mainly_clear
    }
}