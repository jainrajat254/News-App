package org.example.project.presentation.feature.signup.getOtp

sealed interface SignupOtpRequestEvent {
    data object GetOtp : SignupOtpRequestEvent
    data class UpdatePhoneNumber(val phone: String) : SignupOtpRequestEvent
    data object Login : SignupOtpRequestEvent
}