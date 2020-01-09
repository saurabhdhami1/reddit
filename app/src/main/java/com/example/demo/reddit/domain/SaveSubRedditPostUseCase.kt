package com.example.demo.reddit.domain

import com.example.demo.reddit.data.DataRepository
import com.example.demo.reddit.data.remote.models.RedditResponse
import com.example.demo.reddit.funds.UseCase
import io.reactivex.Single
import javax.inject.Inject

class SaveSubRedditPostUseCase @Inject constructor(private val dataRepository: DataRepository) :
    UseCase<RedditResponse, Single<Unit>>() {
    override fun execute(parameters: RedditResponse): Single<Unit> {
        return if (parameters.data != null) {
            dataRepository.setSubRedditPost(parameters.data!!)
            Single.just(Unit)
        } else {
            Single.error(Throwable("Data is empty"))
        }
    }
}