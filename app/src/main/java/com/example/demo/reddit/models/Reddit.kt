package com.example.demo.reddit.models

data class Reddit(var id: String? = null,
                  var name: String? = null,
                  var description: String? = null,
                  var auth: Any? = null,
                  var events: Any? = null,
                  var variables: List<Any>? = null,
                  var order: List<String>? = null,
                  var foldersOrder: List<Any>? = null,
                  var protocolProfileBehavior: List<Any>? = null,
                  var folders: List<Any>? = null,
                  var requests: List<Request>? = null)