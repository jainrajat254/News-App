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
import org.example.project.presentation.components.AppBar
import org.example.project.presentation.components.AppLogo
import org.example.project.presentation.components.ChipGroup
import org.example.project.presentation.components.CustomSearchBar
import org.example.project.presentation.components.NetworkImage
import org.example.project.presentation.feature.drawer.AppSideDrawer
import org.example.project.presentation.feature.home.components.ArticleCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    component: HomeComponent
) {
    val categories = listOf("All", "News", "TV News", "People-Corner")
    var selectedCategory by remember { mutableStateOf(categories[0]) }

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()

    var isSearchVisible by remember { mutableStateOf(false) }
    var searchQuery by remember { mutableStateOf("") }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            AppSideDrawer(
                component = component,
                onItemSelected = { selectedItem ->
                    coroutineScope.launch { drawerState.close() }

                    when (selectedItem) {
                        "notifications" -> component.onEvent(HomeEvent.OnNotificationsClicked)
                        "saved" -> component.onEvent(HomeEvent.OnSavedClicked)
                        "surveys" -> component.onEvent(HomeEvent.OnSurveysClicked)
                        "content_language" -> component.onEvent(HomeEvent.OnContentLanguageClicked)
                        "donate" -> component.onEvent(HomeEvent.OnDonateClicked)
                        "logout" -> component.onEvent(HomeEvent.OnLogOutClicked)
                        else -> Unit
                    }
                }
            )
        }
    ) {
        Scaffold(
            containerColor = Color.White,
            topBar = {
                if (isSearchVisible) {
                    CustomSearchBar(
                        onSearch = { query ->
                            searchQuery = query
                            println("Search query: $searchQuery")
                        },
                        onClose = {
                            isSearchVisible = false
                        }
                    )
                } else {
                    AppBar(
                        startIcon = Icons.Filled.Menu,
                        onStartIconClick = { coroutineScope.launch { drawerState.open() } },
                        endIcon = Icons.Filled.Search,
                        onEndIconClick = { isSearchVisible = !isSearchVisible },
                        centerContent = { AppLogo(size = 40) }
                    )
                }
            },
            content = { paddingValues ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp)
                        .padding(paddingValues)
                        .verticalScroll(rememberScrollState())
                ) {
                    NetworkImage(imageUrl = "https://images.indianexpress.com/2024/08/pm-modi-cover.jpg")

                    Spacer(modifier = Modifier.height(28.dp))

                    ChipGroup(
                        categories = categories,
                        selectedCategory = selectedCategory,
                        onCategorySelected = { selectedCategory = it }
                    )

                    Spacer(modifier = Modifier.height(20.dp))

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

                    ArticleCard(
                        heading = "Making the Most of Outdoor Space for a Bountiful and Beautiful Vegetable Garden",
                        source = "Nature Channel",
                        time = "36 mins ago",
                        imageUrl = "https://images.indianexpress.com/2024/08/pm-modi-cover.jpg"
                    )

                    Spacer(modifier = Modifier.height(16.dp))

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
            }
        )
    }
}
