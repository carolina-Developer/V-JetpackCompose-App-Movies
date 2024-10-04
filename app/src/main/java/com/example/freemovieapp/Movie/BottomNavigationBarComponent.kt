package com.example.freemovieapp.Movie

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun BottomNavigationBar(
    navController: NavController,
    selectedScreen: Int,
    onScreenSelected: (Int) -> Unit
) {
    NavigationBar {
        NavigationBarItem(
            selected = selectedScreen == 0,
            onClick = {
                onScreenSelected(0)
                navController.navigate("welcome")
            },
            icon = { Icon(Icons.Default.Home, contentDescription = "Welcome Screen") },
            label = { Text("Welcome") }
        )

    }
}