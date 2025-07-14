package org.example.project.presentation.feature.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import org.example.project.TabNavigationItem
import org.example.project.presentation.components.AppBar
import org.example.project.presentation.components.ChipGroup
import org.example.project.presentation.components.CustomSearchBar
import org.example.project.presentation.components.NetworkImage
import org.example.project.presentation.feature.auth.components.AppLogo
import org.example.project.presentation.feature.discover.DiscoverTab
import org.example.project.presentation.feature.donate.DonateTab
import org.example.project.presentation.feature.home.components.ArticleCard
import org.example.project.presentation.feature.home.drawer.AppSideDrawer
import org.example.project.presentation.feature.news.NewsTab
import org.example.project.presentation.feature.shorts.ShortsTab
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    val categories = listOf("All", "News", "TV News", "People-Corner")
    var selectedCategory by remember { mutableStateOf(categories[0]) }

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()

    // State for showing/hiding the search bar
    var isSearchVisible by remember { mutableStateOf(false) }
    var searchQuery by remember { mutableStateOf("") }

    // **Place ModalNavigationDrawer for HomeScreen only**
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            AppSideDrawer(
                onItemSelected = { selected ->
                    coroutineScope.launch { drawerState.close() }
                }
            )
        }
    ) {
        Scaffold(
            containerColor = Color.White,
            content = { paddingValues ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp)
                        .padding(paddingValues)
                        .verticalScroll(rememberScrollState())
                ) {
                    // Search bar functionality
                    if (isSearchVisible) {
                        CustomSearchBar(
                            onSearch = { query ->
                                searchQuery = query
                                println("Search query: $searchQuery")
                            },
                            onClose = {
                                isSearchVisible = false  // Close the search bar
                            }
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                    } else {
                        // AppBar with menu and search functionality
                        AppBar(
                            startIcon = Icons.Filled.Menu,
                            onStartIconClick = {
                                coroutineScope.launch { drawerState.open() }
                            },
                            endIcon = Icons.Filled.Search,
                            onEndIconClick = {
                                isSearchVisible = !isSearchVisible
                            },
                            centerContent = {
                                AppLogo(size = 40)
                            }
                        )
                    }

                    // Content inside HomeScreen
                    NetworkImage(imageUrl = "https://images.indianexpress.com/2024/08/pm-modi-cover.jpg")

                    Spacer(modifier = Modifier.height(28.dp))

                    // Category chips
                    ChipGroup(
                        categories = categories,
                        selectedCategory = selectedCategory,
                        onCategorySelected = { selectedCategory = it }
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    // Article Section
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Article",
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            lineHeight = 24.sp
                        )
                        Text(
                            text = "View all",
                            color = Color.Black,
                            fontWeight = FontWeight.W400,
                            fontSize = 12.sp,
                            lineHeight = 18.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    // Sample Article Card
                    ArticleCard(
                        heading = "Making the Most of Outdoor Space for a Bountiful and Beautiful Vegetable Garden",
                        source = "Nature Channel",
                        time = "36 mins ago",
                        imageUrl = "https://images.indianexpress.com/2024/08/pm-modi-cover.jpg"
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Survey Section
                    Text(
                        text = "Survey of the week",
                        color = Color.Black,
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        fontWeight = FontWeight.W700,
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "Which aspect of PM Modi’s US Visit will have most significant impact on US India Ties?",
                        color = Color.Black,
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight.W600,
                    )

                    Spacer(modifier = Modifier.padding(bottom = 40.dp))
                }
            },
            bottomBar = {
                // Show bottom navigation only when drawer is closed
                if (drawerState.isClosed) {
                    NavigationBar(
                        containerColor = Color.White
                    ) {
                        TabNavigationItem(HomeTab)
                        TabNavigationItem(DiscoverTab)
                        TabNavigationItem(ShortsTab)
                        TabNavigationItem(NewsTab)
                        TabNavigationItem(DonateTab)
                    }
                }
            }
        )
    }
}


@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}