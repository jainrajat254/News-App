package org.example.project.presentation.feature.saved

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Download
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.project.presentation.components.AppBar
import org.example.project.presentation.components.NetworkImage

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SavedItemsScreen(
    component: SavedItemsComponent,
    savedItems: List<SavedMediaItem> = emptyList()
) {

    val savedItems = listOf(
        SavedMediaItem(
            url = "https://images.indianexpress.com/2024/08/pm-modi-cover.jpg", // Portrait image
            aspectRatio = 3f / 4f
        ),
        SavedMediaItem(
            url = "https://images.indianexpress.com/2024/08/pm-modi-cover.jpg", // Landscape image
            aspectRatio = 4f / 3f
        ),
        SavedMediaItem(
            url = "https://images.indianexpress.com/2024/08/pm-modi-cover.jpg", // Square
            aspectRatio = 1f
        ),
        SavedMediaItem(
            url = "https://images.indianexpress.com/2024/08/pm-modi-cover.jpg", // Tall
            aspectRatio = 1f / 2f
        ),
        SavedMediaItem(
            url = "https://images.indianexpress.com/2024/08/pm-modi-cover.jpg", // Wide
            aspectRatio = 2f / 1f
        )
    )
    Scaffold(
        containerColor = Color.White,
        topBar = {
            AppBar(
                startIcon = Icons.AutoMirrored.Default.ArrowBack,
                onStartIconClick = { component.onEvent(SavedItemsEvent.OnBackClicked) },
                showBottomBorder = true,
                centerContent = {
                    Text(
                        text = "Saved",
                        color = Color.Black,
                        fontWeight = FontWeight.W700,
                        fontSize = 18.sp,
                        lineHeight = 26.sp
                    )
                }
            )
        },
        content = { paddingValues ->
            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Fixed(2),
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(8.dp),
                verticalItemSpacing = 8.dp,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(savedItems) { item ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(item.aspectRatio)
                    ) {
                        NetworkImage(
                            imageUrl = item.url,
                        )

                        IconButton(
                            onClick = { /* Handle download */ },
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .padding(6.dp)
                                .background(
                                    color = Color.Black.copy(alpha = 0.5f),
                                    shape = CircleShape
                                )
                        ) {
                            Icon(
                                imageVector = Icons.Default.Download,
                                contentDescription = "Download",
                                tint = Color.White,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }
                }
            }
        }
    )
}

data class SavedMediaItem(
    val url: String,
    val aspectRatio: Float = 1f
)
