package org.example.project.presentation.feature.saved

sealed interface SavedItemsEvent {
    data object OnBackClicked : SavedItemsEvent
}