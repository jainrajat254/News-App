package org.example.project.presentation.feature.profile.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.example.project.presentation.components.NetworkImage

@Composable
fun ProfileImage(imageUrl: String? = null) {
    Box(
        contentAlignment = Alignment.BottomEnd,
        modifier = Modifier.size(120.dp)
    ) {
        if (!imageUrl.isNullOrEmpty()) {
            NetworkImage(
                imageUrl = imageUrl,
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
            )
        } else {
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .background(Color.Gray.copy(alpha = 0.2f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Outlined.Person,
                    contentDescription = "Default Profile",
                    modifier = Modifier.size(60.dp),
                    tint = Color.Black
                )
            }
        }
        Box(
            modifier = Modifier
                .size(32.dp) // smaller touch area
                .clip(CircleShape)
                .background(Color(0xFFFF9500))
                .border(0.5.dp, Color(0xFFFF9500), CircleShape)
                .clickable { /* TODO: Handle image edit */ },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = "Edit Profile Picture",
                tint = Color.White,
                modifier = Modifier.size(14.dp) // smaller icon
            )
        }
    }
}