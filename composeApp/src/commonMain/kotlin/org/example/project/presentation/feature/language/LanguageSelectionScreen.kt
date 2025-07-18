package org.example.project.presentation.feature.language

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.project.presentation.components.AppBar
import org.example.project.presentation.components.AuthButton

@Composable
fun LanguageSelectionScreen(
    component: LanguageSelectionComponent
) {

    var selectedLanguage by remember { mutableStateOf("English") }
    val languages =
        listOf("English", "Hindi", "Bengali", "Gujarati", "Kannada", "Marathi", "Tamil", "Telugu")

    Scaffold(
        containerColor = Color.White,
        topBar = {
            AppBar(
                startIcon = Icons.AutoMirrored.Default.ArrowBack,
                onStartIconClick = { component.onEvent(LanguageSelectionEvent.OnBackClicked) },
                endContent = {
                    Text(
                        text = "Skip",
                        color = Color(0xFF7B7F86),
                        modifier = Modifier
                            .clickable { component.onEvent(LanguageSelectionEvent.OnSkipClick) }
                            .padding(vertical = 8.dp),
                    )
                },
                showBottomBorder = true
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(horizontal = 16.dp, vertical = 16.dp)
            ) {
                Text(
                    text = "Choose your preferred language",
                    color = Color.Black,
                    fontWeight = FontWeight.W700,
                    fontSize = 18.sp,
                    lineHeight = 26.sp,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                LazyColumn {
                    items(languages) { language ->
                        LanguageItem(
                            language = language,
                            isSelected = language == selectedLanguage,
                            onClick = { selectedLanguage = language }
                        )
                    }
                }
                Spacer(modifier = Modifier.weight(1f))
                AuthButton(
                    onClick = { component.onEvent(LanguageSelectionEvent.OnSaveClick) },
                    buttonText = "Submit",
                    enabled = selectedLanguage.isNotEmpty()
                )
            }
        }
    )
}
