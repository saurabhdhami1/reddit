package com.example.demo.reddit.data

import com.example.demo.reddit.data.cache.models.RedditPostCache
import com.example.demo.reddit.data.remote.RemoteDataSource
import com.example.demo.reddit.data.remote.models.Data
import com.example.demo.reddit.models.Request
import com.example.demo.reddit.models.VoteUi
import com.example.demo.reddit.utils.PrefManager
import javax.inject.Inject

open class DataRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val cacheDataSource: CacheDataSource,
    private val mockDataSource: MockDataSource,
    private val prefManager: PrefManager
) {
    fun getRedditRequest() = mockDataSource.getReddit().requests

    fun saveOnSharedPref(key: String, value: Any) = prefManager.save(key, value)

    fun getFromSharedPref(key: String, defValue: String = ""): String =
        prefManager.getString(key, defValue)

    fun postRequest(request: Request) = remoteDataSource.postRequest(request)

    fun setAuthentication(authRequest: String) = remoteDataSource.addAuthentication(authRequest)

    fun getPosts(url:String) = remoteDataSource.getPosts(url)
    fun setPost(data: Data) = cacheDataSource.setPost(data)
    fun getPostData() = cacheDataSource.getPostData()
    fun setVote(voteUi: VoteUi) = remoteDataSource.setVote(voteUi)
    fun getRedditPostCache() = cacheDataSource.getRedditPostCache()
    fun setSubRedditPost(data: Data) = cacheDataSource.setSubRedditPost(data)
    fun getSubRedditPost() = cacheDataSource.getSubRedditPost()
}
