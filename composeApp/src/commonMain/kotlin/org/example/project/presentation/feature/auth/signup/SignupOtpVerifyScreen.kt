package org.example.project.presentation.feature.auth.signup

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import org.example.project.presentation.feature.auth.login.LoginOtpRequestScreen

data class SignupOtpVerifyScreen(val phone: String) : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        var otpValues by remember { mutableStateOf(List(4) { "" }) }

        SignupOtpVerifyContent(
            phone = phone,
            otpValues = otpValues,
            onOtpChange = { index, value ->
                otpValues = otpValues.toMutableList().also { it[index] = value }
            },
            onLoginClick = { navigator?.replace(LoginOtpRequestScreen()) }
        )
    }
}
