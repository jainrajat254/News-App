package org.example.project.presentation.feature.donate

import com.arkivanov.decompose.ComponentContext

class DonateComponent(
    componentContext: ComponentContext,
    private val onDonateClicked: () -> Unit,
) : ComponentContext by componentContext {

    fun onEvent(event: DonateEvent) {
        when (event) {
            DonateEvent.OnDonateClicked -> onDonateClicked()
        }
    }
}