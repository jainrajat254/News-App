package org.example.project.presentation.navigation

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val name: String,
    val icon: ImageVector,
    val route: String,
)