package org.example.project.presentation.feature.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.project.presentation.components.NetworkImage
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ArticleCard(
    modifier: Modifier = Modifier,
    heading: String,
    source: String,
    time: String,
    imageUrl: String,
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = heading,
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.W500,
            )

            Spacer(modifier = Modifier.height(3.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = source,
                    color = Color(0xFFF98121),
                    fontSize = 10.sp,
                    lineHeight = 16.sp,
                    fontWeight = FontWeight.W600
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "•",
                    color = Color(0xFFA1A3A4),
                    fontSize = 10.sp,
                    lineHeight = 16.sp,
                    fontWeight = FontWeight.W700
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = time,
                    color = Color(0xFFA1A3A4),
                    fontSize = 10.sp,
                    lineHeight = 16.sp,
                    fontWeight = FontWeight.W700
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            NetworkImage(imageUrl)
        }
    }
}


@Composable
@Preview()
fun ArticleCardPreview() {
    ArticleCard(
        heading = "IMaking the Most of Outdoor Space for a Bountiful and Beautiful Vegetable Garden",
        source = "Nature Channel",
        time = "36 mins ago",
        imageUrl = "https://images.indianexpress.com/2024/08/pm-modi-cover.jpg"
    )
}

