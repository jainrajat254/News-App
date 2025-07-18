package org.example.project.presentation.feature.survey

import com.arkivanov.decompose.ComponentContext

class SurveysComponent(
    componentContext: ComponentContext,
    private val onBackClicked: () -> Unit,
) : ComponentContext by componentContext {

    fun onEvent(event: SurveyEvent) {
        when (event) {
            SurveyEvent.OnBackClicked -> onBackClicked()
        }
    }
}