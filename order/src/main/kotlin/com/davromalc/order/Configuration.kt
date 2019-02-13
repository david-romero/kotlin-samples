package com.davromalc.order

import com.davromalc.order.handlers.OrderHandler
import com.davromalc.order.handlers.PaymentHandler
import com.davromalc.order.listeners.NewOrderListener
import com.davromalc.order.model.OrderCreated
import com.davromalc.order.repositories.OrderRepository
import org.springframework.fu.kofu.configuration
import org.springframework.fu.kofu.mongo.mongodb
import org.springframework.fu.kofu.web.server

val appConfig = configuration {
    beans {
        bean<OrderRepository>()
        bean<OrderHandler>()
        bean<NewOrderListener>()
        bean<PaymentHandler>()
    }
    listener<OrderCreated> {
        ref<NewOrderListener>()
    }
    mongodb {
        uri = "mongodb://mongoadmin:secret@localhost:27017/some-database?authSource=some-db&authMechanism=SCRAM-SHA-256"

    }
    server{
        port = 8080
    }

}