package org.example.project.presentation.feature.auth.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun AuthBackground(
    content: @Composable () -> Unit,
) {
    val orange = Color(0xFFEF7F1B).copy(alpha = 0.5f)

    Box(modifier = Modifier.fillMaxSize().background(Color.White)) {
        Canvas(modifier = Modifier.fillMaxSize().background(Color.White)) {
            val width = size.width
            val height = size.height

            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(orange, Color.Transparent),
                    center = Offset(x = width * 0.85f, y = 0f),  // very top
                    radius = width * 0.7f
                ),
                center = Offset(width * 0.85f, 0f),      // very top
                radius = width
            )


            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(orange, Color.Transparent),
                    center = Offset(x = width * 0.15f, y = height),   // At bottom edge exactly
                    radius = width * 0.7f
                ),
                center = Offset(x = width * 0.15f, y = height),
                radius = width,
            )
        }
        content()
    }
}
