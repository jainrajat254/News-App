package org.example.project.presentation.feature.login.verifyOtp

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LoginOtpVerifyComponent(
    componentContext: ComponentContext,
    val phoneNumber: String,
    private val onVerifyOtp: (String) -> Unit,
    private val onSignup: () -> Unit
) : ComponentContext by componentContext {

    private val _otp = MutableStateFlow("")
    val otp: StateFlow<String> = _otp


    fun onEvent(event: LoginOtpVerifyEvent) {
        when (event) {
            is LoginOtpVerifyEvent.UpdateOtp -> {
                if (event.otp.length <= 4 && event.otp.all { it.isDigit() }) {
                    _otp.value = event.otp
                }
            }

            LoginOtpVerifyEvent.VerifyOtp -> {
                onVerifyOtp(_otp.value)
            }

            LoginOtpVerifyEvent.Signup -> onSignup()
        }
    }
}