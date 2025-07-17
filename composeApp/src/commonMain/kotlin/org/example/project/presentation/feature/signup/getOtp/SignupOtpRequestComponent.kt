package org.example.project.presentation.feature.signup.getOtp

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SignupOtpRequestComponent(
    componentContext: ComponentContext,
    private val onGetOtp: (String) -> Unit,
    private val onLogin: () -> Unit,
) : ComponentContext by componentContext {

    private var _phone = MutableStateFlow("")
    val phone: StateFlow<String> = _phone

    fun onEvent(event: SignupOtpRequestEvent) {
        when (event) {
            SignupOtpRequestEvent.GetOtp -> onGetOtp(phone.value)
            SignupOtpRequestEvent.Login -> onLogin()
            is SignupOtpRequestEvent.UpdatePhoneNumber -> {
                _phone.value = event.phone
            }
        }
    }
}