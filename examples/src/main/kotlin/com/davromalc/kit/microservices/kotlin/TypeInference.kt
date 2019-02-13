package com.davromalc.kit.microservices.kotlin

class TypeInference {

    fun greetingsWithType(name: String): String {
        return "Hello $name"
    }

    fun greetings(name: String) = "Hello $name"

}

fun main(args: Array<String>) {
    val greetingsWithType: String = TypeInference().greetingsWithType(name = "David")
    val greetingsWithoutType = TypeInference().greetings(name = "David")
    print(greetingsWithType) // print: Hello David
    print(greetingsWithoutType) // print: Hello David
}
