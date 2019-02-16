package com.davromalc.checkout.model.events

import com.davromalc.checkout.model.Address
import com.davromalc.checkout.model.Checkout

data class CheckoutCreated(val checkout: Checkout, val address: Address)