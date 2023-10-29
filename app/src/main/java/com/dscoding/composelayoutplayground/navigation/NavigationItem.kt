package com.dscoding.composelayoutplayground.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.outlined.Info
import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val route: String
)

val navigationItems = listOf(
    NavigationItem(
        title = "Categorized List",
        selectedIcon = Icons.Filled.Info,
        unselectedIcon = Icons.Outlined.Info,
        route = Screen.CategorizedListScreen.route
    ),
    NavigationItem(
        title = "Swipeable Pages",
        selectedIcon = Icons.Filled.Info,
        unselectedIcon = Icons.Outlined.Info,
        route = Screen.SwipeablePagesScreen.route
    ),
    NavigationItem(
        title = "Staggered Grid",
        selectedIcon = Icons.Filled.Info,
        unselectedIcon = Icons.Outlined.Info,
        route = Screen.StaggeredGridScreen.route
    ),
    NavigationItem(
        title = "Search List",
        selectedIcon = Icons.Filled.Info,
        unselectedIcon = Icons.Outlined.Info,
        route = Screen.SearchListScreen.route
    ),
    NavigationItem(
        title = "Context Dropdown Menu",
        selectedIcon = Icons.Filled.Info,
        unselectedIcon = Icons.Outlined.Info,
        route = Screen.ContextDropdownMenuScreen.route
    ),


)
