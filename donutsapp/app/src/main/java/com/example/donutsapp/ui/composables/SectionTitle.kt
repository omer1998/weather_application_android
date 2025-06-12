package com.example.donutsapp.ui.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SectionTitle(title: String, modifier: Modifier= Modifier) {
    Text(
        title,
        color = Color.Black,
        fontSize = 20.sp,
        fontWeight = FontWeight(500),
        modifier = modifier.padding(vertical = 25.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewSectionTitle() {
    SectionTitle("Today Offers")
}