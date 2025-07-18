package org.example.project.presentation.feature.language

sealed interface LanguageSelectionEvent {
    data object OnBackClicked : LanguageSelectionEvent
    data object OnSaveClick : LanguageSelectionEvent
    data object OnSkipClick : LanguageSelectionEvent
}