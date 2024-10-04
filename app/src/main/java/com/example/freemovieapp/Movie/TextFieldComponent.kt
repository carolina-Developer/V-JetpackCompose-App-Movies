package com.example.freemovieapp.Movie

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import java.net.URL
import java.net.URLEncoder
import java.nio.charset.StandardCharsets


@Composable
fun TextField_Informaion(navController: NavController) {
    // Atributos de la pelicula
    var movieName by remember { mutableStateOf("") }
    var yearOfCreation by remember { mutableStateOf("") }
    var imageUrl by remember { mutableStateOf("") }
    // Atributo para mostrar error en caso que la url no sea correcta
    var showError by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Add Movie",
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Column {
            OutlinedTextField(
                value = movieName,
                onValueChange = { movieName = it },
                label = { Text("Movie Name") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )
            OutlinedTextField(
                value = yearOfCreation,
                onValueChange = { yearOfCreation = it },
                label = { Text("Year of Creation") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )
            OutlinedTextField(
                value = imageUrl,
                onValueChange = { imageUrl = it },
                label = { Text("Image URL") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )
        }
        if (showError) {
            Text(
                text = "Invalid URL",
                color = Color.Red,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
        Button(
            onClick = {
                if (isValidUrl(imageUrl)) {
                    // Codificar la url de la imagen para enviarla por la navegacion
                    // Se codifica para evitar problemas con caracteres especiales
                    // en la url
                    // Por ejemplo, si la url contiene un espacio, se codifica como %20
                    // y se decodifica al recibirlo
                    // Esto es necesario para que la url sea correcta
                    // Tambien como la url contiene el caracter /, se codifica para evitar
                    // problemas con la navegacion con las rutas
                    val encodedUrl = URLEncoder.encode(imageUrl, StandardCharsets.UTF_8.toString())
                    navController.navigate("movie_preview/$movieName/$yearOfCreation/$encodedUrl")
                } else {
                    showError = true
                }
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "Agregar")
        }
    }
}

fun isValidUrl(url: String): Boolean {
    return try {
        URL(url).toURI()
        true
    } catch (e: Exception) {
        false
    }
}