package com.example.demo.reddit.domain

import com.example.demo.reddit.funds.UseCase
import com.example.demo.reddit.models.ApplicationState
import io.reactivex.Single
import javax.inject.Inject

class FetchSubRedditUseCase @Inject constructor(
    private val getRedditPostUseCase: GetRedditPostUseCase,
    private val applicationState: ApplicationState
) : UseCase<Unit, Single<Unit>>() {
    override fun execute(parameters: Unit): Single<Unit> {
        getRedditPostUseCase.execute(applicationState.currentSubRedditUrl ?: "")
        return Single.just(Unit)
    }
}