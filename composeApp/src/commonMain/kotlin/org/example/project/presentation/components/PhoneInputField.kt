package org.example.project.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PhoneInputField(phone: String, onPhoneChange: (String) -> Unit, readOnly: Boolean) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(12.dp)
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .padding(start = 12.dp, end = 8.dp)
                .clickable { /* country picker */ },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "INA", fontWeight = FontWeight.Medium)
            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = "Dropdown",
                tint = Color(0xFFEF7F1B),
                modifier = Modifier.size(24.dp)
            )
        }

        Spacer(modifier = Modifier.width(2.dp))

        Text(text = "|", color = Color.LightGray, fontSize = 24.sp)

        Spacer(modifier = Modifier.width(8.dp))

        OutlinedTextField(
            value = phone,
            onValueChange = {
                if (it.length <= 10 && it.all { char -> char.isDigit() }) {
                    onPhoneChange(it)
                }
            },
            placeholder = {
                Text(text = "+91 8586424581", color = Color.LightGray)
            },
            modifier = Modifier.weight(1f),
            singleLine = true,
            readOnly = readOnly,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            shape = RoundedCornerShape(0.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color.Transparent,
                focusedBorderColor = Color.Transparent
            )
        )
    }
}