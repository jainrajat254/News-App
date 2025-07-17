package org.example.project.presentation.feature.drawer.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DrawerUserProfile(onProfileClicked: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = "Profile Image",
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape),
            tint = Color.Gray
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column {
            Text(
                text = "Hi, Keshav",
                fontWeight = FontWeight.W600,
                fontSize = 16.sp,
                lineHeight = 24.sp
            )
            Text(
                text = "View profile",
                fontWeight = FontWeight.W400,
                fontSize = 12.sp,
                lineHeight = 18.sp,
                color = Color.Gray,
                modifier = Modifier.clickable { onProfileClicked() }
            )
        }
    }
}