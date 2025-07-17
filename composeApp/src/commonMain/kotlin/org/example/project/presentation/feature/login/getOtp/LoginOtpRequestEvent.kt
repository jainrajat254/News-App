package org.example.project.presentation.feature.login.getOtp

sealed interface LoginOtpRequestEvent {
    data object GetOtp : LoginOtpRequestEvent
    data class UpdatePhoneNumber(val phone: String) : LoginOtpRequestEvent
    data object Signup : LoginOtpRequestEvent
}