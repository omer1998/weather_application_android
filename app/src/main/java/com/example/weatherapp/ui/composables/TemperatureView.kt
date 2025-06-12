package com.example.weatherapp.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R
import com.example.weatherapp.ui.theme.Urbanist

@Composable
fun TemperatureView(
    currentTemp: Float,
    weatherStatus: String = "Partly Cloudy",
    maxTemp: Float,
    minTemp: Float,
    isDay: Boolean,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier.fillMaxWidth()
    ) {

        Text(
            "${currentTemp.toInt().toString()}°C",
            fontWeight = FontWeight(600),
            fontSize = 64.sp,
            letterSpacing = 0.25.sp,
            fontFamily = Urbanist,
            color = if (isDay) Color.White else Color.White
        )
        Text(
            weatherStatus,
            fontWeight = FontWeight(500),
            fontSize = 16.sp,
            letterSpacing = 0.25.sp,
            fontFamily = Urbanist,
            lineHeight = 16.sp,
            color = if (isDay) Color(0x99060414) else Color(0x99FFFFFF)
        )
        Spacer(Modifier.height(12.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                .background(
                    if (isDay) Color(0x14060414) else Color(0x14FFFFFF), RoundedCornerShape(100.dp)
                )
                .padding(horizontal = 24.dp, vertical = 8.dp)
                .wrapContentHeight()

        ) {
            Icon(
                tint = if (isDay) Color(0x99060414) else Color(0xDEFFFFFF),
                painter = painterResource(R.drawable.arrow_up_icon),
                contentDescription = null
            )
            Spacer(Modifier.width(4.dp))
            Text(
                "${maxTemp.toInt().toString()}°C",
                fontWeight = FontWeight(500),
                fontSize = 16.sp,
                letterSpacing = 0.25.sp,
                lineHeight = 16.sp,
                fontFamily = Urbanist,
                color = if (isDay) Color(0x99060414) else Color(0xDEFFFFFF)
            )
            Spacer(Modifier.width(8.dp))
            VerticalDivider(
                thickness = 1.dp, modifier = Modifier.height(14.dp), color = Color(0x3D060414)
            )
            Spacer(Modifier.width(8.dp))
            Icon(
                tint = if (isDay) Color(0x99060414) else Color(0xDEFFFFFF),
                painter = painterResource(R.drawable.arrow_down_icon),
                contentDescription = null
            )
            Spacer(Modifier.width(4.dp))
            Text(
                "${minTemp.toInt().toString()}°C",
                fontWeight = FontWeight(500),
                fontSize = 16.sp,
                letterSpacing = 0.25.sp,
                lineHeight = 16.sp,
                fontFamily = Urbanist,
                color = if (isDay) Color(0x99060414) else Color(0xDEFFFFFF)
            )

        }

    }

}

@Preview(showBackground = true)
@Composable
private fun PreviewMainTemperatureView() {
    TemperatureView(
        currentTemp = 24f, maxTemp = 40f, minTemp = 30f, isDay = false
    )
}