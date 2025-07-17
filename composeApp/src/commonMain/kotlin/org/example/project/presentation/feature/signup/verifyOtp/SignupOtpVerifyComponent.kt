package org.example.project.presentation.feature.signup.verifyOtp

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SignupOtpVerifyComponent(
    componentContext: ComponentContext,
    val phoneNumber: String,
    private val onVerifyOtp: (String) -> Unit,
    private val onLogin: () -> Unit
) : ComponentContext by componentContext {

    private val _otp = MutableStateFlow("")
    val otp: StateFlow<String> = _otp

    fun onEvent(event: SignupOtpVerifyEvent) {
        when (event) {
            is SignupOtpVerifyEvent.UpdateOtp -> {
                if (event.otp.length <= 4 && event.otp.all { it.isDigit() }) {
                    _otp.value = event.otp
                }
            }

            SignupOtpVerifyEvent.VerifyOtp -> {
                onVerifyOtp(_otp.value)
            }

            SignupOtpVerifyEvent.Login -> onLogin()
        }
    }
}