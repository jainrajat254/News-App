package org.example.project.presentation.feature.home

sealed interface HomeEvent {
    data object OnViewProfileClicked : HomeEvent
    data object OnNotificationsClicked : HomeEvent
    data object OnSavedClicked : HomeEvent
    data object OnSurveysClicked : HomeEvent
    data object OnContentLanguageClicked : HomeEvent
    data object OnDonateClicked : HomeEvent
    data object OnLogOutClicked : HomeEvent
}