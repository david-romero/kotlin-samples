package com.davromalc.checkout

import com.davromalc.cart.domain.Item
import com.davromalc.cart.repositories.CartRepository
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.notFound
import org.springframework.web.reactive.function.server.ServerResponse.ok
import reactor.core.publisher.Mono

class CheckoutHandler(private val cartRepository: CartRepository) {

    fun execute(request: ServerRequest): Mono<ServerResponse> {
        return cartRepository.findById(request.pathVariable("id"))
                .flatMap {
                    it.addItem(request.bodyToMono(Item::class.java))
                }.flatMap {
                    cartRepository.save(it)
                }.flatMap {
                    ok().syncBody(it)
                }.switchIfEmpty(notFound().build())
    }

}