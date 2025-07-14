package org.example.project.presentation.feature.auth.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.logo
import org.jetbrains.compose.resources.painterResource

@Composable
fun AppLogo(size: Int = 80) {
    Image(
        painter = painterResource(Res.drawable.logo),
        contentDescription = "App Logo",
        modifier = Modifier.size(size.dp)
    )
}
