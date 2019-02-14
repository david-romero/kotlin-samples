package com.davromalc.cart.repositories

import com.davromalc.cart.domain.Cart
import org.springframework.data.mongodb.core.ReactiveMongoOperations
import org.springframework.data.mongodb.core.findAll
import org.springframework.data.mongodb.core.findById

class CartRepository(private val mongo: ReactiveMongoOperations) {

    fun findById(id: String) = mongo.findById<Cart>(id)

    fun findAll() = mongo.findAll<Cart>()

    fun save(cart: Cart)  = mongo.save(cart)

}