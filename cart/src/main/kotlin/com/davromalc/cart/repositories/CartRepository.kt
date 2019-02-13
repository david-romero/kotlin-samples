package com.davromalc.cart.repositories

import com.davromalc.cart.domain.Cart
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface CartRepository : ReactiveMongoRepository<Cart, String>