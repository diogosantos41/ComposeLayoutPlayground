package com.dscoding.composelayoutplayground.staggeredGrid

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.random.Random

data class GridItem(
    val height: Dp,
    val color: Color
)

val gridItems = (1..100).map {
    GridItem(
        height = Random.nextInt(100, 400).dp,
        color = Color(
            Random.nextLong(0xFFFFFFFF)
        ).copy(alpha = 1f)
    )
}
