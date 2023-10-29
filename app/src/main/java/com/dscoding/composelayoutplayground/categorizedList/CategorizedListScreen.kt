package com.dscoding.composelayoutplayground.categorizedList

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dscoding.composelayoutplayground.data.names

@Composable
fun CategorizedListScreen() {
    val namesList = names.map {
        Category(
            name = it.key.toString(), items = it.value
        )
    }
    CategorizedLazyColumn(categories = namesList)
}

data class Category(
    val name: String, val items: List<String>
)

@Composable
private fun CategoryHeader(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(16.dp)
    )
}

@Composable
private fun CategoryItem(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        fontSize = 14.sp,
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun CategorizedLazyColumn(
    categories: List<Category>, modifier: Modifier = Modifier
) {
    LazyColumn(modifier) {
        categories.forEach { category ->
            stickyHeader {
                CategoryHeader(text = category.name)
            }
            items(category.items) { text ->
                CategoryItem(text = text)
            }
        }

    }
}