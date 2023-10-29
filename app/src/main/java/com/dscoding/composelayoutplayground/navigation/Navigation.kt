package com.dscoding.composelayoutplayground.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dscoding.composelayoutplayground.categorizedList.CategorizedListScreen
import com.dscoding.composelayoutplayground.contextDropMenu.ContextDropdownMenuScreen
import com.dscoding.composelayoutplayground.searchList.SearchListScreen
import com.dscoding.composelayoutplayground.staggeredGrid.StaggeredGridScreen
import com.dscoding.composelayoutplayground.swipeablePages.SwipeablePagesScreen

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