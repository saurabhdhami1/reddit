package com.example.demo.reddit.enum

enum class SearchRequest(val value: String) {
    ACCESS_TOKEN_AUTH("ee5fa6e9-1d64-401b-9cbc-f464118a0db5"),
    GET_REDDIT_POSTS("278cfe28-1c1f-4914-9de5-a14a6fa419d2"),
    GET_COMMENTS_ON_POST("59b73aea-ff3a-47d0-8ea9-2a2ffad85b03"),
    GET_VOTE_ON_POSTS("818bd798-7e8d-4b18-8faa-9b336efdfed9"),
    GET_POPULAR_POSTS("b6cd46e2-561f-4129-954c-5d97710b02c0")
}