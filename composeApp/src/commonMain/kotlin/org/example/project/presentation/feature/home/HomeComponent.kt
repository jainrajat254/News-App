package org.example.project.presentation.feature.home

import com.arkivanov.decompose.ComponentContext

class HomeComponent(
    componentContext: ComponentContext,
    private val onViewProfileClicked: () -> Unit,
    private val onNotificationsClicked: () -> Unit,
    private val onSavedClicked: () -> Unit,
    private val onSurveysClicked: () -> Unit,
    private val onContentLanguageClicked: () -> Unit,
    private val onDonateClicked: () -> Unit,
    private val onLogoutClicked: () -> Unit,
) : ComponentContext by componentContext {

    fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.OnViewProfileClicked -> onViewProfileClicked()
            is HomeEvent.OnNotificationsClicked -> onNotificationsClicked()
            is HomeEvent.OnSavedClicked -> onSavedClicked()
            is HomeEvent.OnSurveysClicked -> onSurveysClicked()
            is HomeEvent.OnContentLanguageClicked -> onContentLanguageClicked()
            is HomeEvent.OnDonateClicked -> onDonateClicked()
            is HomeEvent.OnLogOutClicked -> onLogoutClicked()
        }
    }
}