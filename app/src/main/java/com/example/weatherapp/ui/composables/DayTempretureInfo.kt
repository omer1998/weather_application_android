package com.example.weatherapp.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.colorspace.WhitePoint
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R
import com.example.weatherapp.ui.theme.Urbanist

@Composable
fun DayTemperatureInfo(
    day: String,
    image: Painter,
    highTemp: Float,
    lowTemp: Float,
    isDay: Boolean,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            //.padding(horizontal = 16.dp)
            .height(61.dp)
            .fillMaxWidth()
            .background(if (isDay) Color(0x14060414) else Color(0x14FFFFFF))
            .padding(bottom = 1.dp)
            .background(Color.White),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            day,
            fontFamily = Urbanist,
            fontWeight = FontWeight(400),
            fontSize = 16.sp,
            color = if (isDay) Color(0x99060414) else Color(0x99FFFFFF),
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 16.dp)
        )
        Image(
            image, null, modifier = Modifier
                .size(32.dp)
                .weight(1f)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(end = 16.dp)
                .weight(1.1f)
        ) {
            Icon(
                tint = if (isDay) Color(0xDE060414) else Color(0xDEFFFFFF),
                painter = painterResource(R.drawable.arrow_up_icon),
                contentDescription = null
            )
            Spacer(Modifier.width(4.dp))
            Text(
                "${highTemp.toInt()}°C",
                fontWeight = FontWeight(400),
                fontSize = 14.sp,
                letterSpacing = 0.25.sp,
                lineHeight = 16.sp,
                fontFamily = Urbanist,
                color = if (isDay) Color(0xDE060414) else Color(0xDEFFFFFF)
            )
            Spacer(Modifier.width(8.dp))
            VerticalDivider(
                color = if (isDay) Color(0xDE060414) else Color(0xDEFFFFFF),
                modifier = Modifier.height(14.dp)
            )
            Spacer(Modifier.width(8.dp))
            Icon(
                tint = if (isDay) Color(0xDE060414) else Color(0xDEFFFFFF),
                painter = painterResource(R.drawable.arrow_down_icon),
                contentDescription = null
            )
            Spacer(Modifier.width(4.dp))
            Text(
                "${lowTemp.toInt()}°C",
                fontWeight = FontWeight(400),
                fontSize = 14.sp,
                letterSpacing = 0.25.sp,
                lineHeight = 16.sp,
                fontFamily = Urbanist,
                color = if (isDay) Color(0xDE060414) else Color(0xDEFFFFFF)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewDayTemperatureInfo() {
    DayTemperatureInfo(
        day = "Sunday",
        image = painterResource(R.drawable.clear_sky_image),
        highTemp = 38f,
        lowTemp = 27f,
        isDay = false

    )
}