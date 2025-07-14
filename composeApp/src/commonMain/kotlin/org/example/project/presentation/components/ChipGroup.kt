package org.example.project.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ChipGroup(
    categories: List<String>,
    selectedCategory: String,
    onCategorySelected: (String) -> Unit,
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(horizontal = 12.dp)
    ) {
        items(categories) { category ->
            TopicSelectionChip(
                category = category,
                isSelected = category == selectedCategory,
                onClick = { onCategorySelected(category) }
            )
        }
    }
}

@Preview()
@Composable
fun PreviewChipGroup() {
    var selected by remember { mutableStateOf("All") }

    ChipGroup(
        categories = listOf("All", "News", "TV News", "Articles"),
        selectedCategory = selected,
        onCategorySelected = { selected = it }
    )
}
