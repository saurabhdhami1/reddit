package com.example.demo.reddit.domain

import com.example.demo.reddit.data.DataRepository
import com.example.demo.reddit.data.remote.models.Data
import com.example.demo.reddit.funds.UseCase
import io.reactivex.Single
import javax.inject.Inject

class FetchRedditPostUseCase @Inject constructor(private val dataRepository: DataRepository) :
    UseCase<Unit, Single<Data>>() {
    override fun execute(parameters: Unit): Single<Data> {
        return Single.just(dataRepository.getPostData())
    }
}