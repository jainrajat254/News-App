package org.example.project.presentation.feature.auth.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InlineClickableText(
    normalText: String,
    clickableText: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = 14.sp,
    normalTextColor: Color = Color.Black,
    clickableTextColor: Color = Color(0xFFEF7F1B),
    fontWeight: FontWeight = FontWeight.Normal,
    clickableFontWeight: FontWeight = FontWeight.SemiBold,
) {
    Row(modifier = modifier) {
        Text(
            text = normalText,
            fontSize = fontSize,
            color = normalTextColor,
            fontWeight = fontWeight
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = clickableText,
            fontSize = fontSize,
            color = clickableTextColor,
            fontWeight = clickableFontWeight,
            modifier = Modifier.clickable { onClick() }
        )
    }
}