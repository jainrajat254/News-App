package org.example.project.presentation.feature.signup.getOtp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.example.project.presentation.components.AppLogo
import org.example.project.presentation.components.AuthBackground
import org.example.project.presentation.components.InlineClickableText
import org.example.project.presentation.components.InputSection
import org.example.project.presentation.components.TitleAndSubtitle

@Composable
fun SignupOtpRequestScreen(
    component: SignupOtpRequestComponent,
) {
    val phone by component.phone.collectAsState()
    val isPhoneValid = phone.length == 10 && phone.all { it.isDigit() }

    Scaffold(
        content = { innerPadding ->
            AuthBackground {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                        .padding(horizontal = 24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(60.dp))

                    AppLogo()

                    Spacer(modifier = Modifier.height(20.dp))

                    TitleAndSubtitle(
                        title = "Sign up",
                        subtitle = "Create Your Account",
                        titleColor = Color(0xFFEF7F1B)
                    )

                    Spacer(modifier = Modifier.height(40.dp))

                    InputSection(
                        phone = phone,
                        onPhoneChange = {
                            component.onEvent(
                                SignupOtpRequestEvent.UpdatePhoneNumber(it)
                            )
                        },
                        readOnly = false,
                        buttonText = "Get OTP",
                        onButtonClick = {
                            component.onEvent(
                                SignupOtpRequestEvent.GetOtp
                            )
                        },
                        enabled = isPhoneValid
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    InlineClickableText(
                        normalText = "Already have an account?",
                        clickableText = "Log In",
                        onClick = {
                            component.onEvent(
                                SignupOtpRequestEvent.Login
                            )
                        }
                    )
                }
            }
        }
    )
}
