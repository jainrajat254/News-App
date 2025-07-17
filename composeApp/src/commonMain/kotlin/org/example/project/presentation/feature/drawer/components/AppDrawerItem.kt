package org.example.project.presentation.feature.drawer.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun AppDrawerItem(
    label: String,
    icon: ImageVector,
    onClick: () -> Unit,
    selected: Boolean = false,
    labelColor: Color = Color.Black,
    iconTint: Color = Color(0xFFFF9500),
    fontWeight: FontWeight = FontWeight.W400,
) {
    NavigationDrawerItem(
        label = {
            Text(
                text = label,
                fontWeight = fontWeight,
                fontSize = 14.sp,
                lineHeight = 20.sp,
                color = labelColor
            )
        },
        icon = {
            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = iconTint
            )
        },
        selected = selected,
        onClick = onClick
    )
}