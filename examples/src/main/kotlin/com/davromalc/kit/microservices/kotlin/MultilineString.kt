package com.davromalc.kit.microservices.kotlin

fun example4() =
        """
            You can use raw strings to write multiline text.
            There is no escaping here, so raw strings are useful for writing regex
            patterns, you don't need to escape a backslash by a backslash.
            String template entries (${42}) are allowed here.
        """

fun main(args: Array<String>) { print(example4()) }
