package org.example.project.presentation.feature.profile

import com.arkivanov.decompose.ComponentContext

class ProfileComponent(
    componentContext: ComponentContext,
    private val onSaveClicked: () -> Unit,
    private val onBackClicked: () -> Unit,
) : ComponentContext by componentContext {

    fun onEvent(event: ProfileEvent) {
        when (event) {
            ProfileEvent.OnBackClicked -> onBackClicked()
            ProfileEvent.OnSaveClicked -> onSaveClicked()
        }
    }
}