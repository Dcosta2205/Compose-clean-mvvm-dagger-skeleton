package com.ssup.composeandcleanarchitecture.data.network

import com.ssup.composeandcleanarchitecture.domain.settings.AppSettings
import javax.inject.Inject
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

const val HEADER_X_CLIENT_VERSION = "X-Android-Client-Version"
const val HEADER_X_AUTH_ID_TOKEN = "X-Auth-Id-Token-V2"

class HeadersInterceptor @Inject constructor(val appSettings: AppSettings) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
        val newRequest: Request.Builder =
            request.newBuilder().addHeader(HEADER_X_CLIENT_VERSION, "BuildConfig.VERSION_CODE.toString()")
        appSettings.getAccessToken()?.let { accessToken -> newRequest.addHeader(HEADER_X_AUTH_ID_TOKEN, accessToken) }
        return chain.proceed(newRequest.build())
    }
}