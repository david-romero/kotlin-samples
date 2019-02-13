package com.davromalc.order.listeners

import com.davromalc.order.handlers.OrderHandler
import com.davromalc.order.model.Order
import com.davromalc.order.model.OrderRequested
import org.springframework.amqp.rabbit.annotation.RabbitHandler
import org.springframework.amqp.rabbit.annotation.RabbitListener

@RabbitListener(queues = arrayOf("orders"))
class OrderReceiver(private val orderHandler: OrderHandler) {

    @RabbitHandler
    fun receive(orderRequested: OrderRequested) = {
        println("[x] Received '$orderRequested'")
        orderHandler.create(Order(cartId = orderRequested.cartId, address = orderRequested.address))
    }

}