package org.example.project.presentation.feature.profile.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import org.example.project.presentation.components.AuthButton
import org.example.project.presentation.feature.profile.ProfileComponent
import org.example.project.presentation.feature.profile.ProfileEvent

@Composable
fun ProfileContent(modifier: Modifier = Modifier, component: ProfileComponent) {
    val name = remember { mutableStateOf("Keshav Chandra") }
    val mobile = remember { mutableStateOf("+91 9876543210") }

    val interests = listOf("Technology", "Music", "Travel", "Art", "Fitness")
    val selectedInterests = remember { mutableStateListOf<String>() }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        ProfileImage()

        Spacer(modifier = Modifier.height(24.dp))

        CustomOutlinedTextField(
            value = name.value,
            onValueChange = { name.value = it },
            labelText = "Name"
        )

        Spacer(modifier = Modifier.height(16.dp))

        CustomOutlinedTextField(
            value = mobile.value,
            onValueChange = { mobile.value = it },
            labelText = "Mobile",
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        )


        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Interests",
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            style = MaterialTheme.typography.titleMedium
        )

        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            interests.forEach { interest ->
                val isSelected = interest in selectedInterests

                FilterChip(
                    selected = isSelected,
                    onClick = {
                        if (!isSelected) {
                            selectedInterests.add(interest) // Only add, no removal
                        }
                    },
                    label = { Text(interest) },
                    colors = FilterChipDefaults.filterChipColors(
                        containerColor = Color.Transparent,
                        labelColor = if (isSelected) Color(0xFFFF9500) else Color.Gray,
                        selectedContainerColor = Color(0xFFFFF3E0),
                        selectedLabelColor = Color(0xFFFF9500),
                        disabledContainerColor = Color.Transparent,
                        disabledLabelColor = Color.LightGray
                    ),
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        AuthButton(
            onClick = { component.onEvent(ProfileEvent.OnSaveClicked) },
            buttonText = "Save",
        )
    }
}