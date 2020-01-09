package com.example.demo.reddit.models

data class Auth (var type: String? = null,
                 var bearer: List<Bearer>? = null,
                 var basic: List<Basic>? = null)