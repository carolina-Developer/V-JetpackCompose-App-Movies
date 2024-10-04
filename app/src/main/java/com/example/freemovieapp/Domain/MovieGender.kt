package com.example.freemovieapp.Domain

sealed class MovieGender (val displayName: String) {
    object Animation: MovieGender("Animation")
    object Action: MovieGender("Action")
    object Adventure: MovieGender("Adventure")
}