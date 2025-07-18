package org.example.project.presentation.feature.survey

sealed interface SurveyEvent {
    data object OnBackClicked : SurveyEvent
}