package com.example.demo.reddit.domain

import com.example.demo.reddit.data.DataRepository
import com.example.demo.reddit.funds.UseCase
import io.reactivex.Single
import javax.inject.Inject

class FetchPostPositionUseCase @Inject constructor(private val dataRepository: DataRepository) :
    UseCase<String, Single<Int>>() {
    override fun execute(parameters: String): Single<Int> {
        val childList = dataRepository.getSubRedditPost().get().children
        val position = childList?.filterIndexed { index, child ->
            child.data?.id == parameters
        }
        return Single.just(childList?.indexOf(position?.first()))
    }
}