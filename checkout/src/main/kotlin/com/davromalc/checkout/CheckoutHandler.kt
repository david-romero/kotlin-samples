package com.davromalc.checkout

import com.davromalc.checkout.dto.CheckoutDTO
import com.davromalc.checkout.model.Address
import com.davromalc.checkout.model.Cart
import com.davromalc.checkout.model.Checkout
import com.davromalc.checkout.model.Item
import com.davromalc.checkout.model.events.CheckoutCreated
import com.davromalc.checkout.repository.CheckoutRepository
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.notFound
import org.springframework.web.reactive.function.server.ServerResponse.ok
import reactor.core.publisher.Mono

class CheckoutHandler(val repository: CheckoutRepository, val rabbitClient: RabbitTemplate) {

    fun execute(request: ServerRequest): Mono<ServerResponse> {
        val response = RestTemplate() // Service Discovery
                .getForEntity("http://CART/api/cart/{id}", Cart::class.java, getCartId(request))
        return if (response.hasBeenSuccessfull()) {
            val cart = response.body
            val amount = sumPrices(getItems(cart))
            val checkout = repository
                    .save(Checkout(cartId = getCartId(cart), amount = amount, userId = getUserId(cart)))
            val event = CheckoutCreated(checkout, getAddress(checkout.userId))
            rabbitClient.convertAndSend("orders", event)
            ok().syncBody(checkout)
        } else {
            notFound().build()
        }
    }

    fun sumPrices(items: List<Item>) = items.sumByDouble { item -> (item.quantity.toDouble() * item.price) }

    fun <T> ResponseEntity<T>.hasBeenSuccessfull(): Boolean = this.statusCode == HttpStatus.OK;

    private fun getAddress(userId: String): Address {
        return Address(street = "", city = "", zipCode = 1)
    }

    private fun getCartId(request: ServerRequest) = mapOf("id" to request.pathVariable("cartId"))

    private fun getItems(cart : Cart?) = cart?.items ?: emptyList()

    private fun getUserId(cart : Cart?) = cart?.userId ?: ""

    private fun getCartId(cart: Cart?) = cart?.id ?: ""

    private fun map(checkoutDTO: CheckoutDTO) = Checkout(cartId = checkoutDTO.cartId, amount = checkoutDTO.amount, userId = "")

    fun create(request: ServerRequest): Mono<ServerResponse> {

        return request.bodyToMono(CheckoutDTO::class.java)
                .flatMap {
                    ok().syncBody(repository.save(map(it))!!)
                }.switchIfEmpty(ServerResponse.badRequest().build())

    }

}
