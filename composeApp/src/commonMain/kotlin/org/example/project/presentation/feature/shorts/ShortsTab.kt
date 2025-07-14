package org.example.project.presentation.feature.shorts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Videocam
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import org.example.project.presentation.feature.auth.components.AppLogo
import org.example.project.presentation.feature.auth.components.AuthBackground

object ShortsTab: Tab {
    override val options: TabOptions
        @Composable
        get() {
            val title = "Shorts"
            val icon = rememberVectorPainter(Icons.Default.Videocam)

            return remember {
                TabOptions(
                    index = 0u,
                    title = title,
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        Scaffold(
            content = { innerPadding ->
                AuthBackground {
                    Column(
                        modifier = Modifier.Companion
                            .fillMaxSize()
                            .padding(innerPadding)
                            .padding(horizontal = 32.dp),
                        horizontalAlignment = Alignment.Companion.CenterHorizontally
                    ) {
                        Spacer(modifier = Modifier.Companion.height(150.dp))

                        AppLogo(size = 180)

                        Spacer(modifier = Modifier.Companion.height(20.dp))

                        Text(
                            text = "सोच आपकी",
                            fontWeight = FontWeight.Companion.Bold,
                            fontSize = 45.sp,
                            color = Color(0xFFEF7F1B),
                            modifier = Modifier.Companion.fillMaxWidth(),
                            textAlign = TextAlign.Companion.Center
                        )
                        Text(
                            text = "दहलीज़ पर",
                            fontWeight = FontWeight.Companion.Bold,
                            fontSize = 45.sp,
                            color = Color(0xFFEF7F1B),
                            modifier = Modifier.Companion.fillMaxWidth(),
                            textAlign = TextAlign.Companion.Center
                        )

                        Spacer(modifier = Modifier.Companion.height(30.dp))
                    }
                }
            }
        )
    }
}