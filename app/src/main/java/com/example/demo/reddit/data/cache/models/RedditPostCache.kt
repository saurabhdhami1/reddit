package com.example.demo.reddit.data.cache.models

import com.example.demo.reddit.data.cache.base.MemCache
import com.example.demo.reddit.data.remote.models.Data

class RedditPostCache(data: Data = Data()) : MemCache<Data>(data)