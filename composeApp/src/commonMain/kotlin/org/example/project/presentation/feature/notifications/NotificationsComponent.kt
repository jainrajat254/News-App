package org.example.project.presentation.feature.notifications

import com.arkivanov.decompose.ComponentContext

class NotificationsComponent(
    componentContext: ComponentContext,
    private val onBackClicked: () -> Unit,
) : ComponentContext by componentContext {

    fun onEvent(event: NotificationEvent) {
        when (event) {
            NotificationEvent.OnBackClicked -> onBackClicked()
        }
    }
}