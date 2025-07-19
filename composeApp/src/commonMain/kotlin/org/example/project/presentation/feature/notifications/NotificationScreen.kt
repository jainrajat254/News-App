package org.example.project.presentation.feature.notifications

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import kotlinx.datetime.DatePeriod
import kotlinx.datetime.TimeZone
import kotlinx.datetime.minus
import kotlinx.datetime.toLocalDateTime
import org.example.project.presentation.components.AppBar
import org.example.project.presentation.feature.notifications.components.NotificationRow
import org.example.project.presentation.feature.notifications.components.SectionHeader
import kotlin.time.Clock
import kotlin.time.Duration.Companion.days
import kotlin.time.Duration.Companion.hours
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

data class NotificationItem @OptIn(ExperimentalTime::class) constructor(
    val id: String,
    val message: String,
    val timestamp: Instant,
    val seen: Boolean
)

@OptIn(ExperimentalTime::class)
@Composable
fun NotificationsScreen(component: NotificationsComponent) {
    val notifications = remember { sampleNotifications() }
    val now = Clock.System.now()
    val today = now.toLocalDateTime(TimeZone.currentSystemDefault()).date
    val yesterday = today.minus(DatePeriod(days = 1))

    val grouped = notifications.groupBy {
        val date = it.timestamp.toLocalDateTime(TimeZone.currentSystemDefault()).date
        when (date) {
            today -> "Today"
            yesterday -> "Yesterday"
            else -> date.toString()
        }
    }

    Scaffold(
        containerColor = Color.White,
        topBar = {
            AppBar(
                startIcon = Icons.AutoMirrored.Default.ArrowBack,
                onStartIconClick = { component.onEvent(NotificationEvent.OnBackClicked) },
                showBottomBorder = true,
                centerContent = {
                    Text(
                        text = "Notifications",
                        color = Color.Black,
                        fontWeight = FontWeight.W700,
                        fontSize = 18.sp,
                        lineHeight = 26.sp
                    )
                }
            )
        },
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            grouped.forEach { (title, items) ->
                item { SectionHeader(title) }
                items(items) { notification ->
                    NotificationRow(notification = notification, now = now)
                }
            }
        }
    }
}

@OptIn(ExperimentalTime::class)
fun sampleNotifications(): List<NotificationItem> {
    val now = Clock.System.now()
    return listOf(
        NotificationItem(
            id = "1",
            message = "Tamil Nadu Rupee Symbol Row: Dmk Insult Tamilian While Taking on Lang...",
            timestamp = now.minus(2.hours),
            seen = false
        ),
        NotificationItem(
            id = "2",
            message = "Tamil Nadu Rupee Symbol Row: Dmk Insult Tamilian While Taking on Lang...",
            timestamp = now.minus(20.hours),
            seen = true
        ),
        NotificationItem(
            id = "3",
            message = "Tamil Nadu Rupee Symbol Row: Dmk Insult Tamilian While Taking on Lang...",
            timestamp = now.minus(26.hours),
            seen = false
        ),
        NotificationItem(
            id = "4",
            message = "Tamil Nadu Rupee Symbol Row: Dmk Insult Tamilian While Taking on Lang...",
            timestamp = now.minus(3.days),
            seen = true
        )
    )
}
