package com.davromalc.kit.microservices.kotlin

fun example1(a: Any, b: Any) = "This is some text in which variables ($a, $b) appear."

fun example2(a: Any, b: Any) =
        "You can write it in a Java way as well. Like this: " + a + ", " + b + "!"

fun example3(c: Boolean, x: Int, y: Int) =
        "Any expression can be used: ${if (c) x else y}"
