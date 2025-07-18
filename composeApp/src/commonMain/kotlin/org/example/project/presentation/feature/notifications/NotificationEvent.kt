package org.example.project.presentation.feature.notifications

sealed interface NotificationEvent {
    data object OnBackClicked : NotificationEvent
}