package org.example.project.presentation.feature.home.profile.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    labelText: String,
    hint: String? = null,
    modifier: Modifier = Modifier,
    singleLine: Boolean = true,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    textStyle: TextStyle = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.W600,
        lineHeight = 20.sp
    ),
    containerColor: Color = Color(0xFFFFF0DB),
    borderColor: Color = Color(0xFFFFF0DB)
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            labelText,
            fontSize = 16.sp,
            fontWeight = FontWeight.W400,
            lineHeight = 22.sp
        )
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = modifier.fillMaxWidth(),
            shape = RoundedCornerShape(
                10.dp
            ),
            placeholder = hint?.let { { Text(it) } },
            singleLine = singleLine,
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = containerColor,
                unfocusedContainerColor = containerColor,
                disabledContainerColor = containerColor,

                focusedBorderColor = borderColor,
                unfocusedBorderColor = borderColor,
                disabledBorderColor = borderColor,
                cursorColor = Color(0xFFFF9500),
                selectionColors = TextSelectionColors(
                    handleColor = Color(0xFFFF9500),
                    backgroundColor = Color(0xFFFFF0DB)
                )
            ),
            keyboardOptions = keyboardOptions,
            textStyle = textStyle
        )
    }
}
