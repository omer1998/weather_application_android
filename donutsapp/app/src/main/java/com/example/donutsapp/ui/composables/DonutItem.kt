package com.example.donutsapp.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.donutsapp.R
import com.example.donutsapp.ui.theme.PrimaryColor

@Composable
fun DonutItem(donutImage: Int, title: String, price: Int) {
    Box(
        Modifier
            .padding(top = 40.dp)
            .width(140.dp)
            .height(111.dp)
    ) {
        Box(
            Modifier
                .fillMaxSize()
                .background(
                    Color.White, RoundedCornerShape(
                        topStart = 20.dp, topEnd = 20.dp, bottomEnd = 10.dp, bottomStart = 10.dp
                    )
                )
                .align(Alignment.CenterStart), contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(Modifier.height(30.dp))
                Text(
                    title,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    color = Color(0x99000000)
                )
                Spacer(Modifier.height(10.dp))
                Text(
                    "$$price", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = PrimaryColor
                )


            }
            Box(
                Modifier
                    .align(Alignment.TopCenter)
                    .size(111.dp)
                    .offset(y = -50.dp),

                ) {
                Image(
                    painter = painterResource(donutImage),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .scale(1f)
                )
            }
        }

    }
}


@Preview()
@Composable
fun PreviewDonutItem() {
    DonutItem(title = "Chocolate Cherry", price = 22, donutImage = R.drawable.choclate_cherry_image)
}