package org.example.project.presentation.feature.payment

import com.arkivanov.decompose.ComponentContext

class PaymentComponent(
    componentContext: ComponentContext,
    private val onBackClicked: () -> Unit
) : ComponentContext by componentContext {

    fun onEvent(event: PaymentEvent) {
        when (event) {
            PaymentEvent.OnBackClicked -> onBackClicked()
        }
    }
}