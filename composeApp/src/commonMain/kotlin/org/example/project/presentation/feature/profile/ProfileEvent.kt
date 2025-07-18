package org.example.project.presentation.feature.profile

sealed interface ProfileEvent {
    data object OnBackClicked : ProfileEvent
    data object OnSaveClicked : ProfileEvent
}