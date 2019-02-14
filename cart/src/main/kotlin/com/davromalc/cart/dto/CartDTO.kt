package com.davromalc.cart.dto

import com.davromalc.cart.domain.Item

data class CartDTO (val userId : String, val items: List<Item>)