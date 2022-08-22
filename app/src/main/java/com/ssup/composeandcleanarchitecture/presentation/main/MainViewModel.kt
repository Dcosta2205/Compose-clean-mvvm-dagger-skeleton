package com.ssup.composeandcleanarchitecture.presentation.main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ssup.composeandcleanarchitecture.ui.theme.DataResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mainRepository: MainRepository) :
    ViewModel() { //Inject context via Dagger Hilt

    val data: MutableState<DataResponse?> = mutableStateOf(null)
    val error: MutableState<String> = mutableStateOf("")

    fun getData() {
        viewModelScope.launch {
            mainRepository.getData().collectLatest { response ->
                if (response.error == null) data.value = response.data else error.value =
                    response.error
            }
        }
    }
}