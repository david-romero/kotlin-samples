package com.davromalc.kit.microservices.kotlin

fun nullSafetyWithoutCompilationErrors() {
    var nullString: String? = null
    if (nullString?.length ?: 0 < 3){
        print("Short String")
    } else {
        print("Large String")
    }
}
