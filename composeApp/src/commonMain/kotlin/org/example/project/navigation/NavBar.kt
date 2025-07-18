package org.example.project.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Newspaper
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.VolunteerActivism
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BottomNavigationBar(
    selectedTab: Tab,
    onTabSelected: (Tab) -> Unit
) {
    val selectedColor = Color(0xFFFF9500)
    val unselectedColor = Color(0xFF5E6166)

    NavigationBar(
        containerColor = Color.White,
        modifier = Modifier.padding(horizontal = 8.dp)
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Default.Home,
                    contentDescription = null,
                    tint = if (selectedTab == Tab.Home) selectedColor else unselectedColor
                )
            },
            label = {
                Text(
                    "Home",
                    color = if (selectedTab == Tab.Home) selectedColor else unselectedColor
                )
            },
            selected = selectedTab == Tab.Home,
            onClick = { onTabSelected(Tab.Home) }
        )

        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Default.Search,
                    contentDescription = null,
                    tint = if (selectedTab == Tab.Discover) selectedColor else unselectedColor
                )
            },
            label = {
                Text(
                    "Discover",
                    color = if (selectedTab == Tab.Discover) selectedColor else unselectedColor
                )
            },
            selected = selectedTab == Tab.Discover,
            onClick = { onTabSelected(Tab.Discover) }
        )

        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Default.PlayArrow,
                    contentDescription = null,
                    tint = if (selectedTab == Tab.Shorts) selectedColor else unselectedColor
                )
            },
            label = {
                Text(
                    "Shorts",
                    color = if (selectedTab == Tab.Shorts) selectedColor else unselectedColor
                )
            },
            selected = selectedTab == Tab.Shorts,
            onClick = { onTabSelected(Tab.Shorts) }
        )

        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Default.Newspaper,
                    contentDescription = null,
                    tint = if (selectedTab == Tab.News) selectedColor else unselectedColor
                )
            },
            label = {
                Text(
                    "News",
                    color = if (selectedTab == Tab.News) selectedColor else unselectedColor
                )
            },
            selected = selectedTab == Tab.News,
            onClick = { onTabSelected(Tab.News) }
        )

        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Default.VolunteerActivism,
                    contentDescription = null,
                    tint = if (selectedTab == Tab.Donate) selectedColor else unselectedColor
                )
            },
            label = {
                Text(
                    "Donate",
                    color = if (selectedTab == Tab.Donate) selectedColor else unselectedColor
                )
            },
            selected = selectedTab == Tab.Donate,
            onClick = { onTabSelected(Tab.Donate) }
        )
    }
}

