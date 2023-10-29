package com.dscoding.composelayoutplayground.features.searchList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dscoding.composelayoutplayground.data.allPersons
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

class SearchListViewModel : ViewModel() {

    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _persons = MutableStateFlow(allPersons)
    val persons = searchText
        .combine(_persons) { text, persons ->
            if (text.isBlank()) {
                persons
            } else {
                persons.filter {
                    it.doesMatchSearchQuery(text)
                }
            }
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            initialValue = _persons.value
        )

    fun onSearchTextChange(text: String) {
        _searchText.value = text
    }
}

