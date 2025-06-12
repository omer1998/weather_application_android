package com.example.weatherapp.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.weatherapp.R
import com.example.weatherapp.utils.getWeatherImageFromWeatherCode

@Composable
fun WeatherImageView(
    modifier: Modifier = Modifier, size: Int = 200, weatherCode: Int, isDay: Boolean
) {
    Box(
        modifier = Modifier.size(size.dp), contentAlignment = Alignment.Center
    ) {
        Box(
            modifier
                .blur(200.dp, edgeTreatment = BlurredEdgeTreatment.Unbounded)
                .background(Color(0x5900619D), shape = CircleShape)
                .size(size.dp)

        )
        Image(
            painter = painterResource(getWeatherImageFromWeatherCode(weatherCode, isDay = isDay)),
            contentDescription = "weather status picture",
            modifier = Modifier.fillMaxSize()

            //.shadow(elevation = 1.dp)
        )

    }
}

@Composable
fun SmallWeatherImageView(
    modifier: Modifier = Modifier, size: Int = 120, weatherCode: Int, isDay: Boolean
) {
    Box(
        modifier = Modifier.size(size.dp), contentAlignment = Alignment.Center
    ) {
        Box(
            modifier
                .blur(150.dp, edgeTreatment = BlurredEdgeTreatment.Unbounded)
                .background(Color(0xFF00619D), shape = CircleShape)
                .size(size.dp)


        )
        Image(
            painter = painterResource(getWeatherImageFromWeatherCode(weatherCode, isDay = isDay)),
            contentDescription = "weather status picture",
            modifier = Modifier.fillMaxSize()

            //.shadow(elevation = 1.dp)
        )
    }
}

@Preview(
    showBackground = true,
    //backgroundColor = 0x000000
)
@Composable
private fun PreviewWeatherImageView() {
    Box(Modifier.padding(40.dp)) {
        SmallWeatherImageView(weatherCode = 1, isDay = true)
    }
}