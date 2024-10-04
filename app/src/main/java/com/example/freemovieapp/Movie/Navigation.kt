package com.example.freemovieapp.Movie

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import java.net.URLDecoder
import java.nio.charset.StandardCharsets


@Composable
//control de la navegacion
fun NavigationComponent(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "welcome") {
        composable("welcome") {
            WelcomeScreen(navController)
        }
        composable("text_field") {
            TextField_Informaion(navController)
        }
        composable("movie_preview/{movieName}/{description}/{imageURL}") { backStackEntry: NavBackStackEntry ->
            val movieName = backStackEntry.arguments?.getString("movieName") ?: ""
            val description = backStackEntry.arguments?.getString("description") ?: ""
            val encodedUrl = backStackEntry.arguments?.getString("imageURL") ?: ""
            //decodificar la url de la imagen
            val imageURL = URLDecoder.decode(encodedUrl, StandardCharsets.UTF_8.toString())
            MoviePreview(movieName, description, imageURL)
        }
    }
}

