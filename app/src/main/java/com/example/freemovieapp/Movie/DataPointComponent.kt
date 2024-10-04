package com.example.freemovieapp.Movie

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

data class DataPoint(
    val title: String,
    val description: String
)

@Composable
fun dataPointComponent(dataPoint: DataPoint){
    Column{
        Text(
            text = dataPoint.title,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF039BE5)
        )
        Text(
            text = dataPoint.description,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF5E5B5B)
        )
    }
}


@Composable
fun DataPointComponentPreview(title: String, description: String){
    val data = DataPoint(title = title, description = description)
    dataPointComponent(dataPoint = data)
}