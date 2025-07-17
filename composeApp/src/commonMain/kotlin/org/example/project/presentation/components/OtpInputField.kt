package org.example.project.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OtpInputField(
    otp: String,
    onOtpChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val focusRequesters = remember { List(4) { FocusRequester() } }
    val focusManager = LocalFocusManager.current

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(
            space = 12.dp,
            alignment = Alignment.CenterHorizontally
        ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(4) { index ->
            val digit = otp.getOrNull(index)?.toString() ?: ""
            val isFocused = otp.length == index

            Box(
                modifier = Modifier
                    .size(48.dp)
                    .shadow(
                        elevation = 8.dp,
                        shape = RoundedCornerShape(12.dp),
                        ambientColor = Color(0x99EF7F1B),
                        spotColor = Color(0x99EF7F1B)
                    )
                    .background(Color.White, RoundedCornerShape(12.dp))
                    .border(
                        width = 1.dp,
                        color = if (isFocused) Color(0xFFEF7F1B) else Color.Gray,
                        shape = RoundedCornerShape(12.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                BasicTextField(
                    value = digit,
                    onValueChange = { newDigit ->
                        if (newDigit.length <= 1 && newDigit.all { it.isDigit() }) {
                            val newOtp = buildString {
                                append(otp.padEnd(4, ' '))
                                if (index < length) {
                                    set(index, if (newDigit.isEmpty()) ' ' else newDigit[0])
                                }
                            }.trim()

                            onOtpChange(newOtp)

                            when {
                                newDigit.isNotEmpty() && index < 3 ->
                                    focusRequesters[index + 1].requestFocus()

                                newDigit.isEmpty() && index > 0 ->
                                    focusRequesters[index - 1].requestFocus()

                                newOtp.length == 4 ->
                                    focusManager.clearFocus()
                            }
                        }
                    },
                    textStyle = LocalTextStyle.current.copy(
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    ),
                    modifier = Modifier
                        .fillMaxSize()
                        .focusRequester(focusRequesters[index])
                        .focusProperties {
                            if (index < 3) {
                                next = focusRequesters[index + 1]
                            }
                            if (index > 0) {
                                previous = focusRequesters[index - 1]
                            }
                        },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Done
                    ),
                    singleLine = true,
                    decorationBox = { innerTextField ->
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            if (digit.isEmpty()) {
                                Text(
                                    text = "•",
                                    color = Color.LightGray,
                                    fontSize = 20.sp
                                )
                            }
                            innerTextField()
                        }
                    }
                )
            }
        }
    }

    LaunchedEffect(Unit) {
        if (otp.isEmpty()) {
            focusRequesters.first().requestFocus()
        }
    }
}



