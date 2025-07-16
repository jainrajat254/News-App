package org.example.project.presentation.feature.home.profile

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.example.project.presentation.components.AppBar
import org.example.project.presentation.feature.home.profile.components.ProfileContent
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {
    Scaffold(
        containerColor = Color.White,
        topBar = {
            AppBar(
                startIcon = Icons.AutoMirrored.Outlined.ArrowBack,
                onStartIconClick = {},
                centerContent = {
                    Text(
                        text = "Edit Profile",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.W700,
                        lineHeight = 26.sp
                    )
                },
                showBottomBorder = true
            )
        },
        content = { padding ->
            ProfileContent(Modifier.padding(padding))
        }
    )
}

@Preview
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}

