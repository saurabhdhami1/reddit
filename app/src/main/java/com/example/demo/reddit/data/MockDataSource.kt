package com.example.demo.reddit.data

import android.content.Context
import com.example.demo.reddit.R
import com.example.demo.reddit.models.Reddit
import com.google.gson.Gson
import javax.inject.Inject

open class MockDataSource @Inject constructor(
    private val context: Context,
    private val gson: Gson
) {
    fun getReddit(): Reddit {
        val json = context.resources.openRawResource(R.raw.request_config).bufferedReader().use {
            it.readText()
        }
        return gson.fromJson(json, Reddit::class.java)
    }
}
