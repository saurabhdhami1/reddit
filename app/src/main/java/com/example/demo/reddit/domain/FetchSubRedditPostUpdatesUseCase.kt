package com.example.demo.reddit.domain

import com.example.demo.reddit.data.DataRepository
import com.example.demo.reddit.data.cache.models.SubRedditPostCache
import com.example.demo.reddit.funds.UseCase
import javax.inject.Inject

class FetchSubRedditPostUpdatesUseCase @Inject constructor(private val dataRepository: DataRepository) :
    UseCase<Unit, SubRedditPostCache>() {
    override fun execute(parameters: Unit): SubRedditPostCache {
        return dataRepository.getSubRedditPost()
    }
}