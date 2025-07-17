package org.example.project.presentation.feature.login.verifyOtp

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
import org.example.project.presentation.components.OtpInputField
import org.example.project.presentation.components.TitleAndSubtitle

@Composable
fun LoginOtpVerifyScreen(
    component: LoginOtpVerifyComponent
) {

    val phoneNumber = component.phoneNumber
    val otp by component.otp.collectAsState()
    val isOtpValid = otp.length == 4 && otp.all { it.isDigit() }

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
                        title = "Log in",
                        subtitle = "Enter your details to proceed further",
                        titleColor = Color(0xFFEF7F1B)
                    )

                    Spacer(modifier = Modifier.height(40.dp))

                    InputSection(
                        phone = phoneNumber,
                        onPhoneChange = {},
                        readOnly = true,
                        buttonText = "Submit",
                        isOtpField = true,
                        otpField = {
                            OtpInputField(
                                otp = otp,
                                onOtpChange = {
                                    component.onEvent(LoginOtpVerifyEvent.UpdateOtp(otp = it))
                                }
                            )
                        },
                        onButtonClick = {
                            component.onEvent(LoginOtpVerifyEvent.VerifyOtp)
                        },
                        enabled = isOtpValid
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    InlineClickableText(
                        normalText = "Don't have an account?",
                        clickableText = "Sign up",
                        onClick = {
                            component.onEvent(
                                event = LoginOtpVerifyEvent.Signup
                            )
                        }
                    )
                }
            }
        }
    )
}
