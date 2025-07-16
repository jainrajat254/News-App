package org.example.project.presentation.feature.donate.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.project.presentation.feature.auth.components.AuthButton
import org.example.project.presentation.feature.home.profile.components.CustomOutlinedTextField

@Composable
fun DonateScreenContent(modifier: Modifier = Modifier) {

    val name = remember { mutableStateOf("") }
    val mobile = remember { mutableStateOf("") }
    val amount = remember { mutableStateOf("") }
    val isChecked = remember { mutableStateOf(false) }
    val predefinedAmounts = listOf("₹1000", "₹2000", "₹3000")
    val selectedAmount = remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(top = 30.dp)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomOutlinedTextField(
            value = name.value,
            onValueChange = { name.value = it },
            labelText = "Name",
            hint = "Enter your name",
            containerColor = Color.White,
            borderColor = Color.Gray
        )

        Spacer(modifier = Modifier.height(16.dp))

        CustomOutlinedTextField(
            value = mobile.value,
            onValueChange = { mobile.value = it },
            labelText = "Mobile",
            hint = "Enter your mobile number",
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            containerColor = Color.White,
            borderColor = Color.Gray
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Checkbox(
                checked = isChecked.value,
                onCheckedChange = { isChecked.value = it },
                modifier = Modifier.size(20.dp),
                colors = CheckboxDefaults.colors(
                    checkedColor = Color(0xFFFF9500),
                    checkmarkColor = Color.White,
                    uncheckedColor = Color(0xFFFF9500)
                )
            )
            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "I want to claim 80g benefit",
                color = Color.Black,
                fontWeight = FontWeight.W600,
                fontSize = 14.sp,
                lineHeight = 20.sp
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        CustomOutlinedTextField(
            value = amount.value,
            onValueChange = { amount.value = it },
            labelText = "Send Money",
            hint = "₹1000",
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            containerColor = Color.White,
            borderColor = Color.Gray
        )
        Spacer(modifier = Modifier.height(16.dp))

        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            predefinedAmounts.forEach { amountLabel ->
                val isSelected = selectedAmount.value == amountLabel
                FilterChip(
                    selected = isSelected,
                    onClick = {
                        selectedAmount.value = amountLabel
                        amount.value = amountLabel.removePrefix("₹")
                    },
                    label = { Text(amountLabel) },
                    colors = FilterChipDefaults.filterChipColors(
                        containerColor = Color.Transparent,
                        labelColor = if (isSelected) Color(0xFFFF9500) else Color.Gray,
                        selectedContainerColor = Color(0xFFFFF3E0),
                        selectedLabelColor = Color(0xFFFF9500),
                        disabledContainerColor = Color.Transparent,
                        disabledLabelColor = Color.LightGray
                    )
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        AuthButton(
            onClick = {},
            buttonText = "Donate",
            enabled = name.value.isNotEmpty() && mobile.value.isNotEmpty() && amount.value.isNotEmpty()
        )
    }
}
