package com.example.demo.reddit.domain

import android.util.Base64
import com.example.demo.reddit.data.DataRepository
import com.example.demo.reddit.enum.SearchRequest
import com.example.demo.reddit.funds.UseCase
import com.example.demo.reddit.utils.Constants.Companion.PASSWORD
import com.example.demo.reddit.utils.Constants.Companion.USER_NAME
import io.reactivex.Single
import javax.inject.Inject

class AddAuthenticationInHeaderUseCase @Inject constructor(
    private val dataRepository: DataRepository
) :
    UseCase<Pair<String?, String?>, Single<Unit>>() {
    override fun execute(parameters: Pair<String?, String?>): Single<Unit> =
        Single.create { emmiter ->

            try {

//        if (dataRepository.getFromSharedPref(AUTH_TOKEN).isEmpty()) return Single.just(Unit)

                val request = dataRepository.getRedditRequest()
                    ?.find { it.id == SearchRequest.ACCESS_TOKEN_AUTH.value }
                val userName = request?.auth?.basic?.get(1)?.value ?: ""
                val password = request?.auth?.basic?.get(0)?.value ?: ""
                val credentials = "${userName}:${password}"
                val authRequest =
                    "Basic " + Base64.encodeToString(credentials.toByteArray(), Base64.NO_WRAP)
                dataRepository.saveOnSharedPref(USER_NAME, userName)
                dataRepository.saveOnSharedPref(PASSWORD, password)
                dataRepository.setAuthentication(authRequest)
                emmiter.onSuccess(Unit)
            } catch (e: Exception) {
                emmiter.onError(e)
            }
        }
}