package com.ssup.composeandcleanarchitecture.presentation.data

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.ssup.composeandcleanarchitecture.presentation.main.MainViewModel
import com.ssup.composeandcleanarchitecture.ui.theme.DataResponse

@Composable
fun DataScreen(mainViewModel: MainViewModel) {
    Column {
        Button(onClick = {
            mainViewModel.getData()
        }) {
            Text(text = "Get Data")
        }

        mainViewModel.data.value?.let {
            Data(dataResponse = it)
        }

        if (mainViewModel.error.value.isNotEmpty()) {
            Error(errorMessage = mainViewModel.error.value)
        }
    }
}

@Composable
private fun Data(dataResponse: DataResponse) {
    Text(text = "Data is  ${dataResponse.name}")
}


@Composable
private fun Error(errorMessage: String) {
    // Toast with error
}
