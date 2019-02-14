package com.davromalc.order.handlers

import com.davromalc.order.model.Order

class PaymentHandler {

    fun execute(order: Order){
        println("Calling Paypal API")
    }

}