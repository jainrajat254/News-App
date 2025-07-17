package org.example.project.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun AppBar(
    modifier: Modifier = Modifier,
    startIcon: ImageVector? = null,
    onStartIconClick: (() -> Unit)? = null,
    endIcon: ImageVector? = null,
    onEndIconClick: (() -> Unit)? = null,
    centerContent: (@Composable () -> Unit)? = null,
    showBottomBorder: Boolean = false,
    endContent: (@Composable (() -> Unit))? = null,
) {
    Column(
        modifier = modifier.fillMaxWidth()
            .statusBarsPadding()
    ) {
        Surface(
            modifier = modifier
                .fillMaxWidth(),
            color = Color.White,
            tonalElevation = 0.dp,
            shadowElevation = 0.dp,
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                contentAlignment = Alignment.Center
            ) {
                if (startIcon != null && onStartIconClick != null) {
                    IconButton(
                        onClick = onStartIconClick,
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                    ) {
                        Icon(imageVector = startIcon, contentDescription = "Start Icon")
                    }
                }
                when {
                    endIcon != null && onEndIconClick != null -> {
                        IconButton(
                            onClick = onEndIconClick,
                            modifier = Modifier
                                .align(Alignment.CenterEnd)
                                .padding(end = 16.dp)
                        ) {
                            Icon(imageVector = endIcon, contentDescription = "End Icon")
                        }
                    }

                    endContent != null -> {
                        Box(
                            modifier = Modifier
                                .align(Alignment.CenterEnd)
                                .padding(end = 16.dp)
                        ) {
                            endContent()
                        }
                    }
                }
                centerContent?.invoke()
            }
        }
        if (showBottomBorder) {
            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(),
                thickness = 1.dp,
                color = Color(0xFFFF9500)
            )
        }
    }
}

@Preview
@Composable
fun AppBarPreview() {
    AppBar(
        centerContent = {
            Text(text = "APP Bar")
        }
    )
}