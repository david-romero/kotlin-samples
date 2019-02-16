package com.davromalc.order.handlers

import com.davromalc.order.model.Order
import com.davromalc.order.model.OrderCreated
import com.davromalc.order.model.OrderStatus
import com.davromalc.order.repositories.OrderRepository
import org.springframework.context.ApplicationEventPublisher

class OrderHandler(val orderRepository: OrderRepository,
                   val applicationEventPublisher: ApplicationEventPublisher,
                   val paymentHandler: PaymentHandler) {

    fun create(newOrder: Order) {
        val persistedOrder = orderRepository.save(newOrder)
        paymentHandler.execute(persistedOrder)
        val confirmedOrder = orderRepository.save(persistedOrder.updateStatus(OrderStatus.CONFIRMED))
        applicationEventPublisher.publishEvent(OrderCreated(confirmedOrder))
    }

}