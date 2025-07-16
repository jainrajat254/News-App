package org.example.project

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import org.example.project.presentation.feature.home.HomeTab
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
//        Navigator(WelcomeScreen()) { navigator ->
//            SlideTransition(navigator)
//        }
        TabNavigator(HomeTab) {
            Scaffold(
                containerColor = Color.White,
                content = { paddingValues ->
//                    Column(modifier = Modifier.fillMaxSize()
//                        .padding(paddingValues)) {
                        CurrentTab()
//                    }
                },
//                bottomBar = {
//                    NavigationBar(
//                        containerColor = Color.White
//                    ) {
//                        TabNavigationItem(HomeTab)
//                        TabNavigationItem(DiscoverTab)
//                        TabNavigationItem(ShortsTab)
//                        TabNavigationItem(NewsTab)
//                        TabNavigationItem(DonateTab)
//                    }
//                }
            )
        }
    }
}

@Composable
fun RowScope.TabNavigationItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current
    val selected = tabNavigator.current == tab
    val iconColor =
        if (selected) Color(0xFFFF9500) else Color.Gray  // Change colors based on selection

    NavigationBarItem(
        selected = selected,
        onClick = { tabNavigator.current = tab },
        label = { Text(tab.options.title, color = iconColor) },
        icon = {
            tab.options.icon?.let { Icon(it, contentDescription = null, tint = iconColor) }
        },
        alwaysShowLabel = true,
        colors = NavigationBarItemDefaults.colors(
            unselectedIconColor = Color.Gray,
            selectedIconColor = Color.Blue,
            unselectedTextColor = Color.Gray,
            selectedTextColor = Color.Blue
        )
    )
}



