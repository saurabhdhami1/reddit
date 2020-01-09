package com.example.demo.reddit.data.remote.interceptors

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject

class HeaderInterceptor @Inject
constructor() : Interceptor {
    private var authRequest: String? = null

    fun setAuthentication(authRequest: String) {
        this.authRequest = authRequest
    }

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val requestBuilder = request.newBuilder()

        requestBuilder.addHeader("Accept", "application/json")
        requestBuilder.addHeader("Content-Type", "application/json")
        requestBuilder.addHeader("authType", "basic")
        requestBuilder.addHeader("Authorization", authRequest)

        return chain.proceed(requestBuilder.build())
    }
}