package com.davromalc.checkout.model

data class Checkout(val id: Long? = null, val cartId: String, val amount: Double, val userId: String)