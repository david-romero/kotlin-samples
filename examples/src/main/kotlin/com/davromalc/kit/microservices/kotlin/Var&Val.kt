package com.davromalc.kit.microservices.kotlin

fun dummyTest(){
    val awesomeString = "Kotlin is Awesome!"
    awesomeString = "Wow!" // Compilation Error
}

fun dummyTestWithVar(){
    var awesomeString = "Kotlin is Awesome!"
    awesomeString = "Wow!"
    println(awesomeString) // Wow!
}