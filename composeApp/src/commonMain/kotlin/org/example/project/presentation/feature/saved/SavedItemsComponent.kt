package org.example.project.presentation.feature.saved

import com.arkivanov.decompose.ComponentContext

class SavedItemsComponent(
    componentContext: ComponentContext,
    private val onBackClicked: () -> Unit,
) : ComponentContext by componentContext {

    fun onEvent(event: SavedItemsEvent) {
        when (event) {
            SavedItemsEvent.OnBackClicked -> onBackClicked()
        }
    }
}