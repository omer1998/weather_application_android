package com.example.donutsapp.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.donutsapp.R
import com.example.donutsapp.ui.theme.PrimaryColor

//
//@Composable
//fun ProductCard(donutImage: Int, title:String, description: String, price: Int, discountedPrice: Int) {
//
//    Column(
//        Modifier
//            .background(Color(0xFFD7E4F6), shape = RoundedCornerShape(20.dp))
//            .padding(15.dp)
//            .size(width = 193.dp, height = 325.dp)
//
//
//    ) {
//        Box(
//            Modifier
//                .height(180.dp)
//                .fillMaxWidth()
//        ) {
//
//            Box(
//                modifier = Modifier
//                    .align(Alignment.BottomEnd)
//                    .offset(x = 60.dp)
//                    .zIndex(1f)
//            ) {
//                Image(
//                    painter = painterResource(R.drawable.strawberry_wheel_picture),
//                    contentDescription = null,
//                    Modifier
//                        .size(137.dp)
//                        .scale(3f),
//
//                    )
//            }
//            Box(
//                modifier = Modifier
//                    .align(Alignment.TopStart)
//                    .size(35.dp)
//                    .background(Color.White, CircleShape), contentAlignment = Alignment.Center
//            ) {
//                IconButton(onClick = {}) {
//                    Icon(
//                        painter = painterResource(R.drawable.favorite_icon),
//                        contentDescription = null,
//                        modifier = Modifier.size(20.dp),
//                        tint = PrimaryColor
//                    )
//                }
//            }
//        }
//        Text(title, fontSize = 16.sp, fontWeight = FontWeight(400))
//        Spacer(Modifier.height(9.dp))
//        Text(
//            description,
//            fontSize = 12.sp,
//            letterSpacing = 1.sp,
//            fontWeight = FontWeight(400),
//            color = Color(0x60000000)
//        )
//        Spacer(modifier = Modifier.weight(1f))
//        Row(verticalAlignment = Alignment.Bottom,
//            modifier = Modifier.align(Alignment.End)) {
//            Text(
//                "$$price",
//                fontSize = 14.sp,
//                color = Color(0x60000000),
//                fontWeight = FontWeight.SemiBold,
//                textDecoration = TextDecoration.LineThrough
//            )
//            Spacer(Modifier.width(5.dp))
//            Text("$$discountedPrice", fontSize = 22.sp, fontWeight = FontWeight.SemiBold)
//
//        }
//
//    }
//}

@Composable
fun DonutCard(
    donutImage: Int,
    title: String,
    description: String,
    price: Int,
    discountedPrice: Int,
    color: Color
) {

        Box(
            Modifier.padding(end = 40.dp).size(width = 193.dp, height = 325.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color, shape = RoundedCornerShape(20.dp))
                    .padding(15.dp)
                    .graphicsLayer { clip = false }


            ) {
                Column(
                    modifier = Modifier.matchParentSize()
                ) {
                    Spacer(Modifier.height(150.dp))
                    Text(title, fontSize = 16.sp, fontWeight = FontWeight(400))
                    Spacer(Modifier.height(9.dp))
                    Text(
                        description,
                        fontSize = 12.sp,
                        letterSpacing = 1.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0x60000000)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Row(
                        verticalAlignment = Alignment.Bottom,
                        modifier = Modifier.align(Alignment.End)
                    ) {
                        Text(
                            "$$price",
                            fontSize = 14.sp,
                            color = Color(0x60000000),
                            fontWeight = FontWeight.SemiBold,
                            textDecoration = TextDecoration.LineThrough
                        )
                        Spacer(Modifier.width(5.dp))
                        Text(
                            "$$discountedPrice", fontSize = 22.sp, fontWeight = FontWeight.SemiBold
                        )
                    }
                }

                Box(
                    Modifier
                        .size(137.dp)
                        .offset(x = 60.dp, y = (-20).dp)
                        .align(Alignment.CenterEnd)
                        .zIndex(1f)
                ) {
                    Image(
                        painter = painterResource(donutImage),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .scale(2.4f)
                            .fillMaxWidth()

                    )
                }




                Box(
                    modifier = Modifier
                        .size(35.dp)
                        .background(Color.White, CircleShape)
                        .align(Alignment.TopStart), contentAlignment = Alignment.Center
                ) {
                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(R.drawable.favorite_icon),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp),
                            tint = PrimaryColor
                        )
                    }
                }
            }
        }
    }



@Preview(showBackground = true)
@Composable
fun PreviewProductCard() {
    Box() {
        DonutCard(
            donutImage = R.drawable.choclate_glaze,
            title = "Strawberry Wheel",
            description = "These Baked Strawberry Donuts are filled with fresh strawberries...",
            price = 20,
            discountedPrice = 16,
            color = Color(0xFFD7E4F6)
        )
    }

    //  ProductCard()
}