package com.example.donutsapp.ui.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.donutsapp.R

val navigationScreenIcon :List<Int> = listOf(
    R.drawable.home,
    R.drawable.heart,
    R.drawable.notification,
    R.drawable.buy,
    R.drawable.profile_menue_icon,
)
@Composable
fun BottomNavigationBar(modifier: Modifier=Modifier){
    NavigationBar(
        modifier= modifier.padding(horizontal = 39.dp).fillMaxWidth(),
        containerColor = Color(0xFFF7F7F7),
        contentColor = Color(0xFFFF7074)
    ) {
        navigationScreenIcon.forEach {
            NavigationBarItem(
                selected = false,
                onClick = {},
                icon = {
                    Icon(painterResource(it), contentDescription = null, tint = Color(0xFFFF7074))
                }
            )
        }
    }
}