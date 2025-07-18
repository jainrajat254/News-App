package org.example.project.presentation.feature.donate

sealed interface DonateEvent {
    data object OnDonateClicked : DonateEvent
}