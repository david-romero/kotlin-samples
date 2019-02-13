package com.davromalc.checkout.model

import java.math.BigDecimal

data class Checkout (val id: Long, val cartId: String, val amount : BigDecimal) {
}