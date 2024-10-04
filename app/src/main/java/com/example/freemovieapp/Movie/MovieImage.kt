package com.example.freemovieapp.Movie


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage

@Composable
fun movieImage(imgUrl: String) {
    AsyncImage(
        model = imgUrl,
        contentDescription = "Movie Image",
        modifier = Modifier
            .fillMaxWidth(),
        contentScale = ContentScale.Crop

    )
}

@Composable
@Preview
fun movieImagePreview() {
    movieImage("https://rickandmortyapi.com/api/character/avatar/2.jpeg")
}