package org.example.project.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AuthButton(
    onClick: () -> Unit,
    buttonText: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(52.dp),
        shape = RoundedCornerShape(25.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (enabled) Color(0xFFEF7F1B) else Color.LightGray,
            contentColor = if (enabled) Color.White else Color.DarkGray
        ),
        enabled = enabled
    ) {
        Text(
            text = buttonText,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            fontWeight = FontWeight.W600
        )
    }
}
