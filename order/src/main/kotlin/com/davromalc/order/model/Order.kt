package com.davromalc.order.model

data class Order(val id: String = "", val cartId : String, val status : OrderStatus = OrderStatus.CREATED, val address : Address) {

    fun updateStatus(status: OrderStatus) : Order{
        return Order(this.id, this.cartId ,status, this.address)
    }

}

enum class OrderStatus {
    CREATED,
    CONFIRMED,
    DELIVERED
}