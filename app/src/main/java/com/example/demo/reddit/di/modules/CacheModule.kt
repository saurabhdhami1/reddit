package com.example.demo.reddit.di.modules

import android.app.Application
import com.example.demo.reddit.data.cache.models.RedditPostCache
import com.example.demo.reddit.data.cache.models.SubRedditPostCache
import com.example.demo.reddit.di.scope.ApplicationScope
import dagger.Module
import dagger.Provides

@Module
class CacheModule(private val application: Application) {

    @ApplicationScope
    @Provides
    fun providesRedditPostCache(): RedditPostCache = RedditPostCache()

    @ApplicationScope
    @Provides
    fun providesSubRedditPostCache(): SubRedditPostCache = SubRedditPostCache()
}
