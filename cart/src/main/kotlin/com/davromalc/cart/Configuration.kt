package com.davromalc.cart

import com.davromalc.cart.repositories.CartRepository
import org.springframework.fu.kofu.bean
import org.springframework.fu.kofu.configuration
import org.springframework.fu.kofu.mongo.mongodb
import org.springframework.fu.kofu.web.server

val appConfig = configuration {
    beans {
        bean<CartRepository>()
        bean<CartHandler>()
        bean(::routes)
    }
    mongodb {
        embedded()
    }
    server {
        port = 8080
        codecs {
            jackson()
        }
    }
}