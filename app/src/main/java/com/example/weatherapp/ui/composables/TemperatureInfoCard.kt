package com.example.weatherapp.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R

@Composable
fun TemperatureInfoCard(
    image: Painter, temperature: Float, time: String, isDay: Boolean, modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .widthIn(min = 90.dp)
            .padding(top = 20.dp)
            .background(color =if (isDay) Color(0xB2FFFFFF) else Color(0xB2060414), shape = RoundedCornerShape(20.dp)),
        contentAlignment = Alignment.Center
        //  Color(0xB2FFFFFF)
    ) {
        Box {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .blur(150.dp)
                    .background(Color(0x5900619D), shape = CircleShape)
                    .offset(y = 20.dp)
            )
            Column(
                modifier = Modifier.offset(y = -28.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(modifier = Modifier.size(85.dp), contentAlignment = Alignment.Center) {

                    Image(
                        painter = image, null, contentScale = ContentScale.Fit
                    )
                }


                Spacer(Modifier.height(16.dp))
                Text(
                    "$temperature°C",
                    fontWeight = FontWeight(500),
                    fontSize = 16.sp,
                    lineHeight = 16.sp,
                    letterSpacing = 0.25.sp,
                    color = if(isDay) Color(0xDE060414) else Color(0xDEFFFFFF)
                )
                Spacer(Modifier.height(2.dp))
                Text(
                    time,
                    fontWeight = FontWeight(400),
                    fontSize = 16.sp,
                    lineHeight = 20.sp,
                    letterSpacing = 0.25.sp,
                    color = if (isDay) Color(0x99060414) else Color(0x99FFFFFF)
                )
            }
        }


    }
}

@Preview(
    showBackground = true,
    //backgroundColor = 0xFF0000
)
@Composable
private fun PreviewTemperatureCard() {
    TemperatureInfoCard(
        image = painterResource(R.drawable.clear_sky_image),
        temperature = 37f,
        time = "09:00",
        isDay = false
    )
}