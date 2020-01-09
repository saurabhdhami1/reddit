package com.example.demo.reddit.models

import com.example.demo.reddit.data.remote.models.PostData

class ApplicationState {

    var currentSubRedditUrl: String? = null
    var currentPost: PostData? = null
    fun clearState() {
        currentSubRedditUrl = null
        currentPost = null
    }
}
