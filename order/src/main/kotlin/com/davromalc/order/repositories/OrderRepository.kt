package com.davromalc.order.repositories

import com.davromalc.order.model.Order
import org.springframework.data.mongodb.core.ReactiveMongoOperations

class OrderRepository(private val mongoRepository: ReactiveMongoOperations) {

    fun save(order: Order): Order {
        val saved = mongoRepository.save(order)
        val savedOrder = saved.blockOptional()
        return savedOrder.orElse(Order(cartId = order.cartId, address = order.address))
    }

}