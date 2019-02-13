package com.davromalc.order.model

import org.springframework.context.ApplicationEvent

class OrderCreated(order: Order)
    : ApplicationEvent(order) {
}