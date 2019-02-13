package com.davromalc.order.listeners

import com.davromalc.order.model.OrderCreated
import org.springframework.context.ApplicationListener

class NewOrderListener : ApplicationListener<OrderCreated> {

    override fun onApplicationEvent(event: OrderCreated) {
        println("An order has been created: $event")
    }

}