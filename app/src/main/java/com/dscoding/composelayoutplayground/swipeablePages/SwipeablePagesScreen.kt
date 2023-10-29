package com.dscoding.composelayoutplayground.swipeablePages

import android.util.Log
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.dscoding.composelayoutplayground.data.animals
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SwipeablePagesScreen() {
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState(pageCount = { animals.size })
    val matrix = remember { ColorMatrix() }
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        HorizontalPager(
            state = pagerState,
            key = { animals[it] },
            pageSize = PageSize.Fill,
            modifier = Modifier.padding(bottom = 60.dp)
        ) { index ->
            Log.d("TAG", "${pagerState.currentPageOffsetFraction}")
            val pageOffset = (pagerState.currentPage - index) + pagerState.currentPageOffsetFraction
            val imageSize by animateFloatAsState(
                targetValue = if (pageOffset != 0.0f) 0.75f else 1f,
                animationSpec = tween(durationMillis = 300),
            )
            LaunchedEffect(key1 = imageSize) {
                if (pageOffset != 0.0f) {
                    matrix.setToSaturation(0.5f)
                } else {
                    matrix.setToSaturation(1f)
                }
            }
            Image(
                painter = painterResource(id = animals[index]),
                contentDescription = "Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .graphicsLayer {
                        shape = RoundedCornerShape(16.dp)
                        clip = true
                        scaleX = imageSize
                        scaleY = imageSize
                    },
                colorFilter = ColorFilter.colorMatrix(matrix)
            )
        }
        Box(
            modifier = Modifier
                .offset(y = -(16.dp))
                .fillMaxWidth(0.5f)
                .clip(RoundedCornerShape(100))
                .background(MaterialTheme.colorScheme.primaryContainer)
                .align(Alignment.BottomCenter)
        ) {
            IconButton(
                onClick = { scope.launch { pagerState.animateScrollToPage(pagerState.currentPage - 1) } },
                modifier = Modifier.align(Alignment.CenterStart)
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = "Go back"
                )
            }
            IconButton(
                onClick = { scope.launch { pagerState.animateScrollToPage(pagerState.currentPage + 1) } },
                modifier = Modifier.align(Alignment.CenterEnd)
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "Go forward"
                )
            }
        }
    }
}