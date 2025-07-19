package org.example.project.presentation.feature.notifications.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.project.presentation.feature.notifications.NotificationItem
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@OptIn(ExperimentalTime::class)
@Composable
fun NotificationRow(notification: NotificationItem, now: Instant) {
    val bg = if (!notification.seen) Color(0xFFFFF0E2) else Color.Transparent
    val relTime = formatRelativeTime(notification.timestamp, now)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(bg)
            .padding(vertical = 12.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Replace with actual avatar Image
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Gray, shape = CircleShape)
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = notification.message,
                fontSize = 14.sp,
                fontWeight = FontWeight.W700,
                lineHeight = 20.sp,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.width(12.dp))

        Text(
            text = relTime,
            fontSize = 13.sp,
            color = Color(0xFF999999)
        )
    }
}

@OptIn(ExperimentalTime::class)
fun formatRelativeTime(time: Instant, now: Instant): String {
    val duration = now - time
    return when {
        duration.inWholeHours < 1 -> "${duration.inWholeMinutes}m"
        duration.inWholeHours < 24 -> "${duration.inWholeHours}h"
        else -> "${duration.inWholeDays}d"
    }
}