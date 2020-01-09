package com.example.demo.reddit.data.remote

import com.example.demo.reddit.data.remote.interceptors.HeaderInterceptor
import com.example.demo.reddit.data.remote.services.DeviceApiService
import com.example.demo.reddit.data.remote.services.RedditPostService
import com.example.demo.reddit.models.Request
import com.example.demo.reddit.models.VoteUi
import javax.inject.Inject

open class RemoteDataSource @Inject constructor(
    private val deviceApiService: DeviceApiService,
    private val headerInterceptor: HeaderInterceptor,
    private val redditPostService: RedditPostService
) {

    fun addAuthentication(authRequest: String) {
        headerInterceptor.setAuthentication(authRequest)
    }

    fun postRequest(request: Request) = deviceApiService.postRequest(
        request = request,
        type = request.queryParams?.get(0)?.value ?: "",
        userName = request.queryParams?.get(1)?.value ?: "",
        password = request.queryParams?.get(2)?.value ?: ""
    )

    fun getPosts(url: String) = redditPostService.getPosts(url)

    fun setVote(voteUi: VoteUi) = redditPostService.setVote(voteUi)
}