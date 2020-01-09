package com.example.demo.reddit.domain

import com.example.demo.reddit.data.DataRepository
import com.example.demo.reddit.data.cache.models.RedditPostCache
import com.example.demo.reddit.funds.UseCase
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

class FetchRedditPostUpdatesUseCase @Inject constructor(private val dataRepository: DataRepository) :
UseCase<Unit,RedditPostCache>(){
    override fun execute(parameters: Unit): RedditPostCache {
        return  dataRepository.getRedditPostCache()
    }
}