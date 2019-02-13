package com.davromalc.kit.microservices.kotlin

import java.util.*

data class Influencer (
        val username : String,
        val tweets : Long,
        val content : String,
        val likes : Long,
        val birthday: Date
)