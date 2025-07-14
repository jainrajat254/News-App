package org.example.project.presentation.feature.auth.components

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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OtpInputField(
    otp: List<String>,
    onOtpChange: (Int, String) -> Unit,
) {
    val focusRequesters = remember { List(4) { FocusRequester() } }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(
            space = 12.dp,
            Alignment.CenterHorizontally
        ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        otp.forEachIndexed { index, digit ->
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
                    .border(1.dp, Color.Gray, RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ) {
                BasicTextField(
                    value = digit,
                    onValueChange = {
                        if (it.length <= 1 && it.all { ch -> ch.isDigit() }) {
                            onOtpChange(index, it)
                            if (it.isNotEmpty() && index < otp.lastIndex) {
                                focusRequesters[index + 1].requestFocus()
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
                            next =
                                if (index < otp.lastIndex) focusRequesters[index + 1] else FocusRequester.Default
                            previous =
                                if (index > 0) focusRequesters[index - 1] else FocusRequester.Default
                        },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number
                    ),
                    singleLine = true,
                    decorationBox = { innerTextField ->
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            innerTextField()
                        }
                    }
                )
            }
        }
    }
}



