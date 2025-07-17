package org.example.project.presentation.feature.language

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LanguageItem(
    language: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = language,
            color = if (isSelected) Color(0xFFEF7F1B) else Color(0xFF5E6166),
            fontWeight = FontWeight.W400,
            fontSize = 16.sp,
            lineHeight = 22.sp,
            modifier = Modifier.weight(1f)
        )

        if (isSelected) Icon(
            imageVector = Icons.Default.Check,
            contentDescription = "Selected",
            tint = Color(0xFFEF7F1B)
        )
    }
}