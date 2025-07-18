package org.example.project.presentation.feature.notifications

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.example.project.presentation.components.AppBar

@Composable
fun NotificationsScreen(component: NotificationsComponent) {

    Scaffold(
        containerColor = Color.White,
        topBar = {
            AppBar(
                startIcon = Icons.AutoMirrored.Default.ArrowBack,
                onStartIconClick = { component.onEvent(NotificationEvent.OnBackClicked) },
                showBottomBorder = true,
                centerContent = {
                    Text(
                        text = "Notifications",
                        color = Color.Black,
                        fontWeight = FontWeight.W700,
                        fontSize = 18.sp,
                        lineHeight = 26.sp
                    )
                }
            )
        },
        content = { paddingValues ->
        }
    )
}