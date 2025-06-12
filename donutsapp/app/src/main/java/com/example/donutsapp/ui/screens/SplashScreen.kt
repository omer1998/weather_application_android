package com.example.donutsapp.ui.screens

import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.donutsapp.R

@Composable
fun SplashScreen() {
    Scaffold { innerPadding ->
        innerPadding
        Box(
            modifier = Modifier
                .fillMaxSize()
                // .padding(innerPadding)
                .background(Color(0xFFFED8DF))
                .clip(RectangleShape)
        ) {
            Column {
                Box(
                    Modifier
                        .zIndex(1f)
                        .height(400.dp)
                        .rotate(16f)
                        .offset(x = 20.dp, y = 60.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.multi_donuts),
                        "main donuts picture background",
                        modifier = Modifier
                            .size(width = 700.dp, height = 400.dp)
                            .scale(1.7f),
                        //contentScale = ContentScale.Fit
                    )
                    Box(
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .offset(x = -100.dp, y = -20.dp)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.donut_pink_icing),
                            null,
                            modifier = Modifier.size(150.dp),
                            //contentScale = ContentScale.Fit
                        )
                    }
                    Box(
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .offset(x = -50.dp, y = 10.dp)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.purple_donut),
                            null,
                            modifier = Modifier.size(140.dp),
                            //contentScale = ContentScale.Fit
                        )
                    }
                    Box(
                        modifier = Modifier
                            .size(80.dp)
                            .offset(x = 50.dp, y = -50.dp)
                            .align(Alignment.BottomStart)
                            .rotate(50f)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.donut_pink_icing),
                            null,
                            modifier = Modifier.fillMaxSize(),
                            //contentScale = ContentScale.Fit
                        )
                    }
                    Box(
                        modifier = Modifier
                            .size(150.dp)
                            .align(Alignment.BottomEnd)
                            .rotate(0f)
                            .offset(x = 100.dp)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.eaten_donut),
                            null,
                            modifier = Modifier.fillMaxSize(),
                            //contentScale = ContentScale.Fit
                        )
                    }
                }

                Column(Modifier.padding(vertical = 46.dp, horizontal = 40.dp)) {
                    Text(
                        "Gonuts\n" + "with\n" + "Donuts",
                        lineHeight = 50.sp,
                        fontSize = 54.sp,
                        color = Color(0xFFFF7074),
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(Modifier.height(19.dp))
                    Text(
                        "Gonuts with Donuts is a Sri Lanka dedicated food outlets " + "for specialize manufacturing of Donuts in Colombo, Sri Lanka.",
                        color = Color(0xFFFF9494),
                        lineHeight = 18.sp,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Spacer(Modifier.weight(1f))
                    Button(
                        onClick = {},
                        modifier = Modifier.fillMaxWidth().height(67.dp),
                        shape = RoundedCornerShape(50.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                    ) {
                        Text(
                            "Get Started",
                            color = Color.Black,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.padding(0.dp)
                        )
                    }
                }

            }


//            Box(
//                modifier = Modifier
//                    .align(Alignment.BottomStart)
//                    .fillMaxSize()
//                    .background(Color.White)
//            ) {
//
//            }


        }


    }
}


@Preview(showSystemUi = true)
@Composable
fun PreviewSplashScreen() {
    SplashScreen()
}