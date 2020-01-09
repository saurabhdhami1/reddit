package com.example.demo.reddit.data.remote.models

import com.google.gson.annotations.SerializedName

data class Child(
    var kind: String? = null,
    @SerializedName("data")
    var data: PostData? = null
)

