package com.example.freemovieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.freemovieapp.Movie.BottomNavigationBar
import com.example.freemovieapp.Movie.NavigationComponent
import com.example.freemovieapp.ui.theme.FreeMovieAppTheme


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FreeMovieAppTheme {

                var selectedScreen by remember {
                    mutableIntStateOf(0)
                }

                var navController = rememberNavController() // controller de la navegacion
                val navBackStackEntry by navController.currentBackStackEntryAsState() //estado
                val currentRoute = navBackStackEntry?.destination?.route //Obtiene la routa desde nav

                Scaffold(
//
                    //barra de navegacion
                    bottomBar = {
                        if (currentRoute != "welcome") {
                            BottomNavigationBar(navController, selectedScreen) {
                                selectedScreen = it
                            }
                        }
                    },
                    content = { paddingValues ->
                        Box(
                            modifier = Modifier
                                .padding(paddingValues)
                                .fillMaxSize()
                        ) {
                            NavigationComponent(navController)
                        }
                    }
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FreeMovieAppTheme {

    }
}