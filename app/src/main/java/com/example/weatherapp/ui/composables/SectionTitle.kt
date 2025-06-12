package com.example.weatherapp.ui.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.weatherapp.ui.theme.Urbanist

@Composable
fun SectionTitle(title: String, modifier: Modifier = Modifier) {
    Text(
        title,
        modifier= modifier.fillMaxWidth(),
        fontSize = 20.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight(600),
        fontFamily = Urbanist,
        textAlign = TextAlign.Start
    )
}