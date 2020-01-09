package com.example.demo.reddit.data.remote.services

import com.example.demo.reddit.models.Request
import com.example.demo.reddit.models.TokenResponse
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


interface DeviceApiService {

    @POST("v1/access_token?")
    fun postRequest(
        @Body request: Request,
        @Query("grant_type") type: String,
        @Query("username") userName: String,
        @Query("password") password: String
    ): Single<TokenResponse>

}