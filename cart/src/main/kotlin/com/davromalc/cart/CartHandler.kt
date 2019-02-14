package com.davromalc.cart

import com.davromalc.cart.domain.Cart
import com.davromalc.cart.domain.Item
import com.davromalc.cart.dto.CartDTO
import com.davromalc.cart.repositories.CartRepository
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.*
import org.springframework.web.reactive.function.server.body
import reactor.core.publisher.Mono
import reactor.core.publisher.toMono

class CartHandler(private val cartRepository: CartRepository) {

    fun addItem(request: ServerRequest): Mono<ServerResponse> {
        return cartRepository.findById(request.pathVariable("id"))
                .flatMap {
                    it.addItem(request.bodyToMono(Item::class.java))
                }.flatMap {
                    cartRepository.save(it)
                }.flatMap {
                    ok().syncBody(it)
                }.switchIfEmpty(notFound().build())
    }

    fun create(request: ServerRequest): Mono<ServerResponse>{

       return request.bodyToMono(CartDTO::class.java).flatMap {
           cartRepository.save(map(it)).flatMap(ok()::syncBody)
       }.switchIfEmpty(badRequest().build())

    }

    fun map(cartDTO: CartDTO) = Cart(cartDTO.userId, cartDTO.items)

    fun findOne(request: ServerRequest): Mono<ServerResponse> {
        return cartRepository.findById(request.pathVariable("id"))
                .flatMap {
                    ok().syncBody(it)
                }.switchIfEmpty(notFound().build())
    }

    fun findAll(request: ServerRequest): Mono<ServerResponse> {
        return ok().render("carts", mapOf("carts" to cartRepository.findAll()))
    }

}