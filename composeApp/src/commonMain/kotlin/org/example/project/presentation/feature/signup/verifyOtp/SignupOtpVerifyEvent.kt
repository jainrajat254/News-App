package org.example.project.presentation.feature.signup.verifyOtp

sealed interface SignupOtpVerifyEvent {
    data class UpdateOtp(val otp: String) : SignupOtpVerifyEvent
    data object VerifyOtp : SignupOtpVerifyEvent
    data object Login : SignupOtpVerifyEvent
}