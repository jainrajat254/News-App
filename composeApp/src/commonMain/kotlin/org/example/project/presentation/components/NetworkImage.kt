package org.example.project.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.animation.circular.CircularRevealPlugin
import com.skydoves.landscapist.coil3.CoilImage
import com.skydoves.landscapist.coil3.CoilImageState
import com.skydoves.landscapist.components.rememberImageComponent
import com.skydoves.landscapist.placeholder.shimmer.Shimmer
import com.skydoves.landscapist.placeholder.shimmer.ShimmerPlugin

@Composable
fun NetworkImage(
    imageUrl: String,
    modifier: Modifier = Modifier,
) {
    val imageComponent = rememberImageComponent {
        +ShimmerPlugin(
            shimmer = Shimmer.Flash(
                baseColor = Color.LightGray,
                highlightColor = Color.White
            )
        )
        +CircularRevealPlugin(duration = 500)
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 160.dp, max = 280.dp)
            .clip(RoundedCornerShape(10.dp)),
        contentAlignment = Alignment.Center
    ) {
        CoilImage(
            imageModel = { imageUrl },
            modifier = Modifier.fillMaxSize(),
            component = imageComponent,
            imageOptions = ImageOptions(
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center
            ),
            onImageStateChanged = {
                if (it is CoilImageState.Failure) {
                    println("❌ Image Load Failed: $imageUrl")
                }
            },
            loading = {
                CircularProgressIndicator(modifier = Modifier.size(30.dp))
            },
            success = { imageState, painter ->
                Image(
                    painter = painter,
                    contentDescription = "Article Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            },
            failure = {
                Text(
                    text = "Image failed to load",
                    color = Color.Red,
                    style = MaterialTheme.typography.labelSmall
                )
            }
        )
    }
}
