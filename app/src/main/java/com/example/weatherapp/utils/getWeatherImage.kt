package com.example.weatherapp.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.example.weatherapp.R

fun getWeatherImageFromWeatherCode(code: Int, isDay: Boolean): Int {
    return when (code) {
        0 -> if (isDay) R.drawable.clear_sky_image else R.drawable.clear_sky_night
        1 -> if (isDay) R.drawable.mainly_clear else R.drawable.mainly_clear_night
        2 -> if (isDay) R.drawable.partly_cloudy else R.drawable.partly_cloudy_night
        3 -> R.drawable.overcast
        45 -> R.drawable.fog
        48 -> R.drawable.depositing_rime_fog
        51 -> R.drawable.drizzle_light
        53 -> R.drawable.drizzle_moderate
        55 -> R.drawable.drizzle_intensity
        56 -> R.drawable.freezing_drizzle_light
        57 -> R.drawable.freezing_drizzle_intensity
        61 -> if (isDay) R.drawable.rain_slight else R.drawable.rain_moderate_night
        63 -> if (isDay) R.drawable.rain_moderate else R.drawable.rain_moderate_night
        65 -> if (isDay) R.drawable.rain_heavy else R.drawable.rain_heavy_night
        66 -> R.drawable.freezing_light
        67 -> R.drawable.freezing_heavy
        71 -> if (isDay) R.drawable.snow_fall_light else R.drawable.snow_fall_slight_night
        73 -> if (isDay) R.drawable.snow_fall_moderate else R.drawable.snow_fall_moderate_night
        75 -> R.drawable.snow_fall_heavy
        77 -> R.drawable.snow_grains
        80 -> if (isDay) R.drawable.rain_shower_slight else R.drawable.rain_shower_slight_night
        81 -> if (isDay) R.drawable.rain_shower_moderate else R.drawable.rain_shower_moderate_night
        82 -> if (isDay) R.drawable.rain_shower_violent else R.drawable.rain_shower_heavy_night
        85 -> R.drawable.snow_shower_slight
        86 -> R.drawable.snow_shower_heavy
        95 -> R.drawable.thunderstrom_slight_moderate
        96 -> R.drawable.thunderstrom_with_slight_hail
        99 -> R.drawable.thunderstrom_with_heavy_hail
        else -> R.drawable.mainly_clear
    }
}