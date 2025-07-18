package org.example.project.presentation.feature.payment

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.example.project.presentation.components.AppBar
import org.example.project.presentation.feature.payment.components.PaymentStatusScreenContent

@Composable
fun PaymentStatusScreen(component: PaymentComponent) {
    Scaffold(
        containerColor = Color.White,
        topBar = {
            AppBar(
                startIcon = Icons.AutoMirrored.Default.ArrowBack,
                onStartIconClick = { component.onEvent(PaymentEvent.OnBackClicked) },
            )
        },
        content = { paddingValues ->
            PaymentStatusScreenContent(modifier = Modifier.padding(paddingValues))
        }
    )
}