package com.davromalc.checkout.repository

import com.davromalc.checkout.model.Checkout
import org.springframework.data.jpa.repository.JpaRepository

interface CheckoutRepository : JpaRepository<Checkout, Long>