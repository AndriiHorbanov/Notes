package com.example.notesap

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DataViewModel(): ViewModel() {
    private val _state = MutableStateFlow(emptyList<Data>())
    val state: StateFlow<List<Data>> = _state.asStateFlow()

    fun addData(text: String){
        _state.update { dataList -> dataList + Data(text) }

    }

    fun removeData(data: Data) {
        _state.update { dataList -> dataList - data }
    }

}