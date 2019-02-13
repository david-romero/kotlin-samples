package com.davromalc.kit.microservices.kotlin;


class Person(val first: String = "Mr", val last: String = "") {

    fun sayHello() {
        println("Hello ${first} ${last}")
    }
}

fun sayHello(first: String = "Mr", last: String = ""){
    println("Hello $first $last")
}


fun main(args: Array<String>) {
    sayHello()  //>Hello Mr
    sayHello("John") //>Hello John
    sayHello(last = "Doe") //>Hello Mr Doe
    Person(last = "Doe").sayHello()  //>Hello Mr Doe
}

