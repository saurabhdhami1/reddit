package com.example.demo.reddit.domain

import com.example.demo.reddit.data.DataRepository
import com.example.demo.reddit.data.remote.models.RedditResponse
import com.example.demo.reddit.funds.UseCase
import io.reactivex.Single
import javax.inject.Inject

class SaveRedditPostToCacheUseCase @Inject constructor(private val dataRepository: DataRepository) :
    UseCase<RedditResponse, Single<Unit>>() {
    override fun execute(parameters: RedditResponse): Single<Unit> {
        return if (parameters.data != null) {
            dataRepository.setPost(parameters.data!!)
            Single.just(Unit)
        } else {
            Single.error(Throwable("Data is empty"))
        }
    }
}