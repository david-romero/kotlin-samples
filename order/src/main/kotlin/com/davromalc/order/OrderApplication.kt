package com.davromalc.order


import com.davromalc.order.properties.OrderProperties
import org.springframework.fu.kofu.application

val app = application {
	configurationProperties<OrderProperties>("order")
	enable(appConfig)
}

fun main(args: Array<String>) {
	app.run()
}

