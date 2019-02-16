package com.davromalc.checkout.model

data class Cart (val id : String, val userId : String, val items: List<Item>)