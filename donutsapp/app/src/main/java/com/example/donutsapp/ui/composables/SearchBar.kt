package com.example.donutsapp.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.donutsapp.R
import com.example.donutsapp.ui.theme.PrimaryColor

@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    Row(modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
        Column {
            Text(
                "Let’s Gonuts!",
                color = PrimaryColor,
                fontSize = 30.sp,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                "Order your favourite donuts from here",
                color = Color(0x60000000),
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
        }

        IconButton(onClick = {},
            modifier = Modifier.background(Color(0xFFFED8DF), RoundedCornerShape(10.dp)).size(40.dp),
            colors = IconButtonDefaults.iconButtonColors(
                containerColor = Color(0xFFFED8DF),
            )) {
            Icon(
                painter = painterResource(R.drawable.search_icon),
                tint = PrimaryColor,
                contentDescription = null,
                modifier = Modifier.size(24.dp)

            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSearchBar(){
    SearchBar()
}