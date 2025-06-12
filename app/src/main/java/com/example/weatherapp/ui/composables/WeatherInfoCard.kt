package com.example.weatherapp.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R

@Composable
fun WeatherInfoCard(title: String, data: String, icon: Painter, modifier: Modifier = Modifier) {
    Card(
        modifier
            //.width(108.dp)
            .height(115.dp)
            .clip(RoundedCornerShape(24.dp))


    ) {
        Column(
            modifier = Modifier
                //.widthIn(min = 108.dp)
                .fillMaxWidth()
                .height(115.dp)
                .background(color = Color(0xB2FFFFFF))
                .padding(16.dp)
            //    .fillMaxSize()
            ,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = icon, null, modifier = Modifier.size(32.dp), tint = Color(0xFF87CEFA)
            )
            Spacer(Modifier.height(8.dp))
            Text(
                data,
                fontWeight = FontWeight(500),
                fontSize = 20.sp,
                lineHeight = 20.sp,
                letterSpacing = 0.25.sp,
                color = Color(0xDE060414),
                overflow = TextOverflow.Ellipsis
            )
            Spacer(Modifier.height(2.dp))
            Text(
                title,
                fontWeight = FontWeight(400),
                fontSize = 14.sp,
                lineHeight = 20.sp,
                letterSpacing = 0.25.sp,
                color = Color(0x99060414)
            )
        }
    }
}

@Preview
@Composable
private fun PreviewWeatherInfoCard() {
    WeatherInfoCard(
        icon = painterResource(R.drawable.wind_icon),
        title = "Wind",
        data = "13 KM/h",
    )
}