package org.example.project.presentation.feature.donate.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.example.project.presentation.components.AppBar
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun PaymentStatusScreen() {
    Scaffold(
        containerColor = Color.White,
        topBar = {
            AppBar(
                startIcon = Icons.AutoMirrored.Default.ArrowBack,
                onStartIconClick = {},
            )
        },
        content = { paddingValues ->
            PaymentStatusScreenContent(modifier = Modifier.padding(paddingValues))
        }
    )
}

@Composable
@Preview
fun PaymentStatusScreenPreview() {
    PaymentStatusScreen()
}