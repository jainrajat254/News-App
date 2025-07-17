package org.example.project.presentation.feature.onboarding

import com.arkivanov.decompose.ComponentContext

class WelcomeComponent(
    componentContext: ComponentContext,
    private val onSignupClicked: () -> Unit,
    private val onLoginClicked: () -> Unit
) : ComponentContext by componentContext {

    fun onEvent(event: WelcomeEvent) {
        when (event) {
            WelcomeEvent.OnSignUpClick -> onSignupClicked()
            WelcomeEvent.OnLoginClick -> onLoginClicked()
        }
    }
}