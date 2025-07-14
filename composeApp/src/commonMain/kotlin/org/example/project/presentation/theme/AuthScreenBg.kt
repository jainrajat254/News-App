package org.example.project.presentation.theme

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

fun authScreenBg(width: Float, height: Float): Brush {
    return Brush.linearGradient(
        colors = listOf(
            Color(0x95EF7F1B),
            Color.White,
            Color(0x95EF7F1B)
        ),
        start = Offset(x = width, y = 0f),
        end = Offset(x = 0f, y = height)
    )
}
