package org.example.project.presentation.feature.language

import com.arkivanov.decompose.ComponentContext

class LanguageSelectionComponent(
    componentContext: ComponentContext,
    private val onSaveClicked: () -> Unit,
    private val onSkipClicked: () -> Unit,
) : ComponentContext by componentContext {

    fun onEvent(event: LanguageSelectionEvent) {
        when (event) {
            is LanguageSelectionEvent.OnSaveClick -> onSaveClicked()
            is LanguageSelectionEvent.OnSkipClick -> onSkipClicked()
        }
    }
}