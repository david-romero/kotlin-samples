package com.davromalc.checkout.repository

import com.davromalc.checkout.model.Checkout
import org.springframework.data.r2dbc.function.DatabaseClient

class CheckoutRepository(private val client: DatabaseClient){

    fun save(checkout: Checkout): Checkout {
        val saved = client.insert().into(Checkout::class.java).table("checkout").using(checkout).map { t, _ -> t.get("id", Checkout::class.java) }.one()
        val savedCheckout = saved.blockOptional()
        return savedCheckout.orElse(Checkout(cartId= checkout.cartId, amount= checkout.amount, userId = checkout.userId))!!
    }

    fun findById(id: Long): Checkout {
        var monoCheckout = client.execute().sql("SELECT * FROM checkout WHERE id = \$1").bind(1, id).`as`(Checkout::class.java).fetch().one()
        return monoCheckout.blockOptional().get()
    }
}

