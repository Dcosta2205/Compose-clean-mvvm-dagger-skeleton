package com.ssup.composeandcleanarchitecture.presentation.main

import com.ssup.composeandcleanarchitecture.data.network.DataService
import com.ssup.composeandcleanarchitecture.domain.state.DataState
import com.ssup.composeandcleanarchitecture.ui.theme.DataResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MainRepository(private val dataService: DataService) {
    fun getData(): Flow<DataState<DataResponse>> = flow {
        emit(DataState.success(dataService.getData()))
    }.catch { error ->
        emit(DataState.error(error.message))
    }.flowOn(Dispatchers.IO)
}