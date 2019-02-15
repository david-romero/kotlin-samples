package com.davromalc.checkout

import com.davromalc.checkout.dto.CheckoutDTO
import com.davromalc.checkout.model.Cart
import com.davromalc.checkout.model.Checkout
import com.davromalc.checkout.model.Item
import com.davromalc.checkout.repository.CheckoutRepository
import org.springframework.web.client.RestTemplate
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import reactor.core.publisher.Mono
import java.math.BigDecimal
import java.util.function.Consumer

class CheckoutHandler(private val checkoutRepository: CheckoutRepository) {

    fun execute(request: ServerRequest) : Mono<ServerResponse> {

        val parameters = mapOf("id" to request.pathVariable("cartId"))
        val cart = RestTemplate().getForEntity("http://localhost:8080/api/cart/{id}", Cart::class.java, parameters).body

        return ok().syncBody(calculatePrize(cart!!.items))
    }

    private fun calculatePrize(items: List<Item>): Double {
        return items.sumByDouble { item -> (item.quantity.toDouble() * item.price)}
    }

    private fun map(checkoutDTO: CheckoutDTO) = Checkout(cartId =  checkoutDTO.cartId, amount =  checkoutDTO.amount)

    fun create(request: ServerRequest): Mono<ServerResponse>{

        return request.bodyToMono(CheckoutDTO::class.java)
                .flatMap {
                    ok().syncBody(checkoutRepository.save(map(it))!!)
        }.switchIfEmpty(ServerResponse.badRequest().build())

    }

}
