package org.example.project.presentation.feature.onboarding

sealed interface WelcomeEvent {
    data object OnSignUpClick : WelcomeEvent
    data object OnLoginClick : WelcomeEvent
}