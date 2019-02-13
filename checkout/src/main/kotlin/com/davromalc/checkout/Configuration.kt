package com.davromalc.checkout

import com.davromalc.checkout.repository.CheckoutRepository
import org.springframework.fu.kofu.bean
import org.springframework.fu.kofu.configuration
import org.springframework.fu.kofu.r2dbc.r2dbcPostgresql
import org.springframework.fu.kofu.web.server
import routes

val appConfig = configuration {
    beans {
        bean<CheckoutRepository>()
        bean<CheckoutHandler>()
        bean(::routes)
    }
    r2dbcPostgresql()
    server {
        port = 8080
        codecs {
            jackson()
        }
    }
}