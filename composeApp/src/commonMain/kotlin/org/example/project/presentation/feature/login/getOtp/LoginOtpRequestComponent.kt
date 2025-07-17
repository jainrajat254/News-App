package org.example.project.presentation.feature.login.getOtp

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LoginOtpRequestComponent(
    componentContext: ComponentContext,
    private val onGetOtp: (String) -> Unit,
    private val onSignup: () -> Unit,
) : ComponentContext by componentContext {

    private var _phone = MutableStateFlow("")
    val phone: StateFlow<String> = _phone

    fun onEvent(event: LoginOtpRequestEvent) {
        when (event) {
            LoginOtpRequestEvent.GetOtp -> onGetOtp(phone.value)
            LoginOtpRequestEvent.Signup -> onSignup()
            is LoginOtpRequestEvent.UpdatePhoneNumber -> {
                _phone.value = event.phone
            }
        }
    }
}