package com.davromalc.cart.domain

import reactor.core.publisher.Mono

data class Cart (val userId : String, val items: List<Item>) {

    fun addItem(item: Mono<Item>)= item.map { item -> Cart(this.userId, this.items + item) }

}