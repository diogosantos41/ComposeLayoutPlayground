package com.dscoding.composelayoutplayground.navigation

sealed class Screen(val route: String) {
    object CategorizedListScreen: Screen("categorized_list_screen")
    object SwipeablePagesScreen: Screen("swipeable_pages_screen")
    object StaggeredGridScreen: Screen("staggered_grid_screen")
    object SearchListScreen: Screen("search_list_screen")
    object ContextDropdownMenuScreen: Screen("context_dropdown_menu_screen")
}