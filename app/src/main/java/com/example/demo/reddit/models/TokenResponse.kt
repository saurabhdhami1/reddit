package com.example.demo.reddit.models

import com.google.gson.annotations.SerializedName

data class TokenResponse(
    @SerializedName("access_token")
    var accessToken: String,
    @SerializedName("token_type")
    var tokenType: String,
    @SerializedName("expires_in")
    var expiresIn: String,
    var scope: String
)