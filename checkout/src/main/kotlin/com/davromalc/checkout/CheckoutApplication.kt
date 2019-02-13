package com.davromalc.checkout

import com.davromalc.checkout.properties.CheckoutProperties
import org.springframework.fu.kofu.webApplication

val app = webApplication {
    configurationProperties<CheckoutProperties>("checkout")
    enable(appConfig)
}

fun main(args: Array<String>) {
    app.run()
}

