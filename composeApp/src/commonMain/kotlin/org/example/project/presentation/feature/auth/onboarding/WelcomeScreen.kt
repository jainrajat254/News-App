package org.example.project.presentation.feature.auth.onboarding

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import org.example.project.presentation.feature.auth.login.LoginOtpRequestScreen
import org.example.project.presentation.feature.auth.signup.SignupOtpRequestScreen

class WelcomeScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        WelcomeScreenContent(
            onclick = { navigator?.replace(SignupOtpRequestScreen()) },
            onLoginClick = { navigator?.replace(LoginOtpRequestScreen()) },
            buttonText = "Sign Up"
        )
    }
}