package com.example.demo.reddit.data.remote.models

data class Data(
    var modhash: Any? = null,
    var dist: Int? = null,
    var children: List<Child>? = null,
    var after: String? = null,
    var before: Any? = null )


