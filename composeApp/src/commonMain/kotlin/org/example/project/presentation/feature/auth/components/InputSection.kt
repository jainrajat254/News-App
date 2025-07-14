package org.example.project.presentation.feature.auth.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InputSection(
    phone: String,
    onPhoneChange: (String) -> Unit,
    readOnly: Boolean,
    buttonText: String,
    onButtonClick: () -> Unit = {},
    isOtpField: Boolean = false,
    enabled: Boolean = true,
    otpField: @Composable () -> Unit = {},
) {
    AuthContentCard {
        Text(
            text = "Mobile",
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(8.dp))

        PhoneInputField(phone = phone, onPhoneChange = onPhoneChange, readOnly = readOnly)

        Spacer(modifier = Modifier.height(36.dp))

        if (isOtpField) {
            otpField()
            Spacer(modifier = Modifier.height(36.dp))
        }

        AuthButton(buttonText = buttonText, onClick = onButtonClick, enabled = enabled)

        Spacer(modifier = Modifier.height(24.dp))

    }
}