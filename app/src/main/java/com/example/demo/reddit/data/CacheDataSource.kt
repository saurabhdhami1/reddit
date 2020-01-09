package com.example.demo.reddit.data

import com.example.demo.reddit.data.cache.models.RedditPostCache
import com.example.demo.reddit.data.cache.models.SubRedditPostCache
import com.example.demo.reddit.data.remote.models.Data
import com.example.demo.reddit.models.ApplicationState
import javax.inject.Inject

open class CacheDataSource @Inject constructor(
    private val applicationState: ApplicationState,
    private val redditPostCache: RedditPostCache,
    private val subRedditPostCache: SubRedditPostCache
) {
    fun setPost(postData: Data) = redditPostCache.update(postData)
    fun getRedditPostCache(): RedditPostCache = redditPostCache
    fun getPostData() = redditPostCache.get()
    fun setSubRedditPost(data: Data) = subRedditPostCache.update(data)
    fun getSubRedditPost() = subRedditPostCache

}