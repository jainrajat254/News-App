package org.example.project.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun CustomSearchBar(
    onSearch: (String) -> Unit = {},
    onClose: () -> Unit = {},
) {
    var query by remember { mutableStateOf(TextFieldValue("")) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        OutlinedTextField(
            value = query,
            onValueChange = { newValue ->
                query = newValue
                onSearch(query.text)
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Search,
                keyboardType = KeyboardType.Text
            ),
            placeholder = {
                Text(
                    text = "Search for a news",
                    fontWeight = FontWeight.W400,
                    fontSize = 16.sp,
                    lineHeight = 22.sp
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search",
                    modifier = Modifier
                        .size(30.dp)
                        .padding(end = 8.dp),
                    tint = Color.Gray
                )
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = "Close",
                    modifier = Modifier
                        .size(24.dp)
                        .padding(end = 8.dp)
                        .clickable {
                            onClose()
                        },
                    tint = Color.Gray
                )
            },
            shape = RoundedCornerShape(30.dp),
            modifier = Modifier
                .weight(1f)
                .wrapContentHeight()
        )
    }
}

@Preview
@Composable
fun PreviewCustomSearchBar() {
    CustomSearchBar(
        onSearch = { query ->
            println("Searching for: $query")
        }
    )
}
