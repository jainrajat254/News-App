package org.example.project.presentation.feature.payment

sealed interface PaymentEvent {
    data object OnBackClicked : PaymentEvent
}