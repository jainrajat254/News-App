package org.example.project.presentation.feature.survey

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.project.presentation.components.AppBar
import org.example.project.presentation.components.AuthButton

data class SurveyQuestion(
    val id: Int,
    val question: String,
    val options: List<String>,
    var selectedOption: Int? = null
)

@Composable
fun SurveyScreen(component: SurveysComponent) {
    var questions by remember {
        mutableStateOf(
            listOf(
                SurveyQuestion(
                    1,
                    "Which aspect of PM Modi’s US Visit will have most significant impact on US India Ties?",
                    listOf(
                        "Expansion of energy trade (oil,gas LNG)",
                        "Expansion of energy trade (oil,gas LNG)",
                        "Expansion of energy trade (oil,gas LNG)",
                        "Expansion of energy trade (oil,gas LNG)"
                    )
                ),
                SurveyQuestion(
                    2,
                    "Which aspect of PM Modi’s US Visit will have most significant impact on US India Ties?",
                    listOf(
                        "Expansion of energy trade (oil,gas LNG)",
                        "Expansion of energy trade (oil,gas LNG)",
                        "Expansion of energy trade (oil,gas LNG)",
                        "Expansion of energy trade (oil,gas LNG)"
                    )
                )
            )
        )
    }

    Scaffold(
        topBar = {
            AppBar(
                startIcon = Icons.AutoMirrored.Filled.ArrowBack,
                onStartIconClick = { component.onEvent(SurveyEvent.OnBackClicked) },
                centerContent = {
                    Text(
                        text = "Surveys",
                        color = Color.Black,
                        fontWeight = FontWeight.W700,
                        fontSize = 18.sp,
                        lineHeight = 26.sp
                    )
                },
                endContent = {
                    Text(
                        text = "${questions.count { it.selectedOption != null }}/${questions.size}",
                        color = Color.Black,
                        fontWeight = FontWeight.W400,
                        fontSize = 16.sp,
                        lineHeight = 22.sp
                    )
                },
                showBottomBorder = true
            )
        },
        containerColor = Color.White,
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(16.dp)
                    .padding(horizontal = 16.dp)
                    .fillMaxSize()
            ) {
                questions.forEachIndexed { index, question ->
                    Text(
                        text = question.question,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )

                    question.options.forEachIndexed { optIndex, option ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    questions = questions.toMutableList().also {
                                        it[index] = it[index].copy(selectedOption = optIndex)
                                    }
                                }
                                .padding(
                                    vertical = 6.dp,
                                    horizontal = 8.dp
                                ), // ✅ horizontal padding added
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = question.selectedOption == optIndex,
                                onClick = null, // click handled in Row
                                colors = RadioButtonDefaults.colors(
                                    selectedColor = Color(0xFFFF9500) // ✅ updated selected color
                                )
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = option,
                                color = Color.Black,
                                fontWeight = FontWeight.W400,
                                fontSize = 14.sp,
                                lineHeight = 20.sp
                            )
                        }
                    }

                    if (question.selectedOption != null) {
                        AuthButton(
                            onClick = { /* Handle submit */ },
                            buttonText = "Submit",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 16.dp)
                                .padding(horizontal = 16.dp)
                                .height(48.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(24.dp))
                }
            }
        }
    )
}