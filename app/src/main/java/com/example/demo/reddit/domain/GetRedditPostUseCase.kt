package com.example.demo.reddit.domain

import com.example.demo.reddit.data.DataRepository
import com.example.demo.reddit.data.remote.models.RedditResponse
import com.example.demo.reddit.funds.UseCase
import com.example.demo.reddit.utils.Constants
import com.example.demo.reddit.utils.Constants.Companion.BEARER
import io.reactivex.Single
import javax.inject.Inject

class GetRedditPostUseCase @Inject constructor(private val dataRepository: DataRepository) :
    UseCase<String, Single<RedditResponse>>() {
    override fun execute(parameters: String): Single<RedditResponse> {
        val authRequest = dataRepository.getFromSharedPref(Constants.AUTH_TOKEN)
        dataRepository.setAuthentication("$BEARER $authRequest")
        return dataRepository.getPosts(parameters)
    }
}