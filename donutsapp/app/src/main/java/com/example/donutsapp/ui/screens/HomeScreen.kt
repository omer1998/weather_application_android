package com.example.donutsapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.donutsapp.R
import com.example.donutsapp.ui.composables.BottomNavigationBar
import com.example.donutsapp.ui.composables.DonutCard
import com.example.donutsapp.ui.composables.DonutItem
import com.example.donutsapp.ui.composables.SearchBar
import com.example.donutsapp.ui.composables.SectionTitle


@Composable
fun HomeScreen() {
    Scaffold(
        containerColor = Color(0xFFF7F7F7), bottomBar = {
            BottomNavigationBar()
        }) { innerPadding ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(innerPadding)
                
        ) {

            SearchBar(Modifier.padding(horizontal = 39.dp))
            SectionTitle("Today Offers", Modifier.padding(horizontal = 39.dp))
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(2.dp),
                contentPadding = PaddingValues(horizontal = 39.dp)
            ) {
                item {
                    DonutCard(
                        donutImage = R.drawable.strawberry_wheel_picture,
                        title = "Strawberry Wheel",
                        description = "These Baked Strawberry Donuts are filled with fresh strawberries...",
                        price = 20,
                        discountedPrice = 16,
                        Color(0xFFD7E4F6)
                    )
                }
                item {
                    DonutCard(
                        donutImage = R.drawable.choclate_glaze,
                        title = "Chocolate Glaze",
                        description = "Moist and fluffy baked chocolate donuts full of chocolate flavor.",
                        price = 20,
                        discountedPrice = 16,
                        color = Color(0xFFFFC7D0)
                    )
                }
            }
            SectionTitle("Donuts", Modifier.padding(horizontal = 39.dp))

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(21.dp),
                contentPadding = PaddingValues(horizontal = 39.dp)
            ) {
                item {
                    DonutItem(
                        title = "Chocolate Cherry",
                        price = 22,
                        donutImage = R.drawable.choclate_cherry_image
                    )

                }
                item {
                    DonutItem(
                        title = "Strawberry Rain",
                        price = 22,
                        donutImage = R.drawable.strawberry_rain_picture
                    )

                }
                item {
                    DonutItem(title = "Strawberry ", price = 22, donutImage = R.drawable.strawberry)

                }
            }

        }

    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}