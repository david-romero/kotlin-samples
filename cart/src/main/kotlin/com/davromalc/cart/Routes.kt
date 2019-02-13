package com.davromalc.cart

import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.reactive.function.server.router

fun routes(cartHandler: CartHandler) =
        router {
            ("/api/cart" and accept(APPLICATION_JSON))
                    .nest {
                        GET("/{id}", cartHandler::findOne)
                        GET("/", cartHandler::findAll)
                    }
            ("/api/cart/item" and accept(APPLICATION_JSON))
                    .nest {
                        POST("/{id}", cartHandler::addItem)
                    }
        }
