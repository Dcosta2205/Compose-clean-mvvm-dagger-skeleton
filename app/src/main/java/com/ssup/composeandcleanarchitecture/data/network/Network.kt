package com.ssup.composeandcleanarchitecture.data.network

import android.content.Context
import com.ssup.composeandcleanarchitecture.domain.AppSettings
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Network(private val context: Context) {

    private val httpClient = OkHttpClient.Builder().addNetworkInterceptor {
        val request: Request.Builder = it.request().newBuilder()
        AppSettings(context).getAccessToken()?.let { accessToken ->
            request.addHeader("Authorization", "Bearer $accessToken")
        }
        it.proceed(request.build())
    }.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    private val retrofit = Retrofit.Builder().baseUrl("https://www.base.url")
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient)
        .build()


    val client: DataService = retrofit.create(DataService::class.java)
}