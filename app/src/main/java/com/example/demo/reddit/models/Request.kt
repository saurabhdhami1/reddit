package com.example.demo.reddit.models

data class Request(
    var id: String? = null,
    var name: String? = null,
    var url: String? = null,
    var description: String? = null,
    var data: Any? = null,
    var dataOptions: Any? = null,
    var dataMode: Any? = null,
    var headerData: Any? = null,
    var method: String? = null,
    var auth: Auth? = null,
    var events: Any? = null,
    var queryParams: List<QueryParam>? = null,
    var folder: Any? = null,
    var currentHelper: String? = null,
    var helperAttributes: HelperAttributes? = null,
    var collectionId: String? = null,
    var pathVariables: List<Any>? = null,
    var protocolProfileBehavior: ProtocolProfileBehavior? = null,
    var headers: String? = null,
    var authorization: String = ""
)