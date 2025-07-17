package org.example.project.presentation.feature.onboarding

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.project.presentation.components.AppLogo
import org.example.project.presentation.components.AuthBackground
import org.example.project.presentation.components.AuthButton
import org.example.project.presentation.components.InlineClickableText

@Composable
fun WelcomeScreen(
    component: WelcomeComponent
) {
    Scaffold(
        content = { innerPadding ->
            AuthBackground {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                        .padding(horizontal = 32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(150.dp))

                    AppLogo(size = 180)

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = "सोच आपकी",
                        fontWeight = FontWeight.Bold,
                        fontSize = 45.sp,
                        color = Color(0xFFEF7F1B),
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = "दहलीज़ पर",
                        fontWeight = FontWeight.Bold,
                        fontSize = 45.sp,
                        color = Color(0xFFEF7F1B),
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(30.dp))

                    AuthButton(
                        onClick = { component.onEvent(WelcomeEvent.OnSignUpClick) },
                        buttonText = "Sign up",
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    InlineClickableText(
                        normalText = "Already have an account?",
                        clickableText = "Log In",
                        onClick = {
                            component.onEvent(WelcomeEvent.OnLoginClick)
                        }
                    )
                }
            }
        }
    )
}
