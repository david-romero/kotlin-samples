package com.davromalc.cart

import com.davromalc.cart.properties.CartProperties
import org.springframework.fu.kofu.webApplication

val app = webApplication {
    configurationProperties<CartProperties>("cart")
    enable(appConfig)
}

fun main(args: Array<String>) {
    app.run()
}

