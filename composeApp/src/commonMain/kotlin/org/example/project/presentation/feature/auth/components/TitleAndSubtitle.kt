package org.example.project.presentation.feature.auth.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TitleAndSubtitle(
    title: String,
    subtitle: String,
    titleColor: Color = Color.Black,
) {
    Text(
        text = title,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        color = titleColor
    )
    Spacer(modifier = Modifier.height(6.dp))
    Text(
        text = subtitle,
        fontSize = 16.sp,
        color = Color.Gray
    )
}