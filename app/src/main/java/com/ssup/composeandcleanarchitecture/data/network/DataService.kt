package com.ssup.composeandcleanarchitecture.data.network

import com.ssup.composeandcleanarchitecture.ui.theme.DataResponse
import retrofit2.http.GET

interface DataService {
    @GET("/endpoint")
    suspend fun getData(): DataResponse
}