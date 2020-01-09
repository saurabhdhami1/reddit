package com.example.demo.reddit.data.remote.services

import com.example.demo.reddit.data.remote.models.RedditResponse
import com.example.demo.reddit.models.VoteUi
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Url

interface RedditPostService {
    @GET
    fun getPosts(@Url url:String): Single<RedditResponse>

    @POST("api/vote")
    fun setVote(@Body voteUi: VoteUi): Single<Unit>
}