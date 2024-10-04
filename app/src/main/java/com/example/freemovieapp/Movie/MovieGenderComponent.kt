package com.example.freemovieapp.Movie

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.freemovieapp.Domain.MovieGender

@Composable
fun movieGender(movieStatus : MovieGender){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .border(
                width = 1.5.dp,
                color = Color(0xFF40DA08),
                shape = RoundedCornerShape(12.dp)
            )
            .padding(horizontal = 12.dp, vertical = 4.dp)
    ){
        val string = buildAnnotatedString {
            append("Movie: ")
            withStyle(
                style = SpanStyle(
                    color = Color(0xFF000000),
                    fontWeight = FontWeight.Bold

                )
            ){
                append("${movieStatus.displayName}")
            }
        }
        Text(
            text = string,
            fontSize = 20.sp,
            color = Color(0xFF000000)
        )
    }
}

@Composable
@Preview
fun MovieGenderPreviewAction(){
    movieGender(movieStatus = MovieGender.Action)
}

@Composable
@Preview
fun MovieGenderPreviewAnimation(){
    movieGender(movieStatus = MovieGender.Animation)
}

@Composable
@Preview
fun MovieGenderPreviewAdventure(){
    movieGender(movieStatus = MovieGender.Adventure)
}