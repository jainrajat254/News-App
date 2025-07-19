package org.example.project.presentation.feature.drawer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.outlined.Assessment
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.example.project.presentation.feature.drawer.components.AppDrawerItem
import org.example.project.presentation.feature.drawer.components.DrawerHeader
import org.example.project.presentation.feature.drawer.components.DrawerUserProfile

@Composable
fun AppSideDrawer(
    onItemSelected: (String) -> Unit = {},
) {
    Box(
        modifier = Modifier
            .background(Color.White)
            .padding(16.dp)
            .width(250.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            DrawerHeader()

            Spacer(modifier = Modifier.height(24.dp))

            DrawerUserProfile(
                onProfileClicked = { onItemSelected("profile") }
            )
            Spacer(modifier = Modifier.height(16.dp))

            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                thickness = 1.dp,
                color = Color(0xFFFF9500)
            )

            AppDrawerItem(
                label = "Notifications",
                icon = Icons.Outlined.Notifications,
                onClick = { onItemSelected("notifications") }
            )
            AppDrawerItem(
                label = "Saved",
                icon = Icons.Outlined.Bookmark,
                onClick = { onItemSelected("saved") }
            )
            AppDrawerItem(
                label = "Surveys",
                icon = Icons.Outlined.Assessment,
                onClick = { onItemSelected("surveys") }
            )
            AppDrawerItem(
                label = "Content Language",
                icon = Icons.Default.Language,
                onClick = { onItemSelected("content_language") }
            )

            Spacer(modifier = Modifier.weight(1f))

            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                thickness = 1.dp,
                color = Color(0xFFE0E0E0)
            )

            AppDrawerItem(
                label = "Log out",
                icon = Icons.AutoMirrored.Filled.Logout,
                onClick = { onItemSelected("logout") },
                labelColor = Color(0xFFFF9500),
                fontWeight = FontWeight.W600
            )
        }
    }
}