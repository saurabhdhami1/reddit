package com.example.demo.reddit.domain

import com.example.demo.reddit.data.DataRepository
import com.example.demo.reddit.enum.SearchRequest
import com.example.demo.reddit.funds.UseCase
import com.example.demo.reddit.utils.Constants.Companion.AUTH_TOKEN
import io.reactivex.Single
import javax.inject.Inject

class SetAccessTokenUseCase @Inject constructor(private val dataRepository: DataRepository) :
    UseCase<Unit, Single<Unit>>() {
    override fun execute(parameters: Unit): Single<Unit> {
        val request = dataRepository.getRedditRequest()
            ?.find { it.id == SearchRequest.ACCESS_TOKEN_AUTH.value }
        val tokenResponse = request?.let { dataRepository.postRequest(it) }
        val accessToken = tokenResponse?.blockingGet()?.accessToken ?: ""
        dataRepository.saveOnSharedPref(AUTH_TOKEN, accessToken)
        return Single.just(Unit)
    }
}