package com.dscoding.composelayoutplayground.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dscoding.composelayoutplayground.features.categorizedList.CategorizedListScreen
import com.dscoding.composelayoutplayground.features.contextDropMenu.ContextDropdownMenuScreen
import com.dscoding.composelayoutplayground.features.searchList.SearchListScreen
import com.dscoding.composelayoutplayground.features.staggeredGrid.StaggeredGridScreen
import com.dscoding.composelayoutplayground.features.swipeablePages.SwipeablePagesScreen

@Composable
fun Navigation(navController: NavHostController, modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        NavHost(
            navController = navController,
            startDestination = Screen.CategorizedListScreen.route
        )
        {
            composable(route = Screen.CategorizedListScreen.route) {
                CategorizedListScreen()
            }
            composable(route = Screen.SwipeablePagesScreen.route) {
                SwipeablePagesScreen()
            }
            composable(route = Screen.StaggeredGridScreen.route) {
                StaggeredGridScreen()
            }
            composable(route = Screen.SearchListScreen.route) {
                SearchListScreen()
            }
            composable(route = Screen.ContextDropdownMenuScreen.route) {
                ContextDropdownMenuScreen()
            }
        }
    }
}