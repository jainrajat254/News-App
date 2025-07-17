package org.example.project.presentation.feature.login.verifyOtp

sealed interface LoginOtpVerifyEvent {
    data class UpdateOtp(val otp: String) : LoginOtpVerifyEvent
    data object VerifyOtp : LoginOtpVerifyEvent
    data object Signup : LoginOtpVerifyEvent
}