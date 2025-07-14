package org.example.project.presentation.feature.auth.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import org.example.project.presentation.feature.auth.signup.SignupOtpRequestScreen

class LoginOtpRequestScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        var phone by remember { mutableStateOf("") }
        LoginOtpRequestContent(
            phone = phone,
            onPhoneChange = { phone = it },
            onGetOtpClick = { navigator?.push(LoginOtpVerifyScreen(phone = phone)) },
            onSignUpClick = { navigator?.replace(SignupOtpRequestScreen()) }
        )
    }
}