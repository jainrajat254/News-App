package org.example.project.presentation.feature.donate

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.example.project.presentation.components.AppBar
import org.example.project.presentation.feature.donate.components.DonateScreenContent

@Composable
fun DonateScreen(
    component: DonateComponent
) {
    Scaffold(
        containerColor = Color.White,
        topBar = {
            AppBar(
                centerContent = {
                    Text(
                        text = "Details & Payment",
                        color = Color.Black,
                        fontWeight = FontWeight.W600,
                        fontSize = 16.sp,
                        lineHeight = 24.sp
                    )
                },
                showBottomBorder = true
            )
        },
        content = { paddingValues ->
            DonateScreenContent(modifier = Modifier.padding(paddingValues), component = component)
        },
    )
}
