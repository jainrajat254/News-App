package org.example.project.presentation.feature.auth.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.example.project.presentation.feature.auth.components.AuthBackground
import org.example.project.presentation.feature.auth.components.AppLogo
import org.example.project.presentation.feature.auth.components.InlineClickableText
import org.example.project.presentation.feature.auth.components.InputSection
import org.example.project.presentation.feature.auth.components.OtpInputField
import org.example.project.presentation.feature.auth.components.TitleAndSubtitle
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun LoginOtpVerifyContent(
    phone: String,
    otpValues: List<String>,
    onOtpChange: (index: Int, value: String) -> Unit,
    onSignUpClick: () -> Unit,
) {
    val isOtpValid = otpValues.size == 4 && otpValues.all { it.length == 1 && it[0].isDigit() }

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
                        phone = phone,
                        onPhoneChange = {},
                        readOnly = true,
                        buttonText = "Submit",
                        isOtpField = true,
                        otpField = {
                            OtpInputField(
                                otp = otpValues,
                                onOtpChange = onOtpChange
                            )
                        },
                        enabled = isOtpValid
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    InlineClickableText(
                        normalText = "Don't have an account?",
                        clickableText = "Sign up",
                        onClick = onSignUpClick
                    )
                }
            }
        }
    )
}

@Preview()
@Composable
fun PreviewLoginOtpVerifyContent() {
    LoginOtpVerifyContent(
        phone = "",
        otpValues = listOf("", "", "", ""),
        onOtpChange = { _, _ -> },
        onSignUpClick = {}
    )
}
