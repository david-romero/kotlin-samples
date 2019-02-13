package com.davromalc.kit.microservices.kotlin

class Test {

    fun `given a new Person when the Person say hello Then a message is printed`{
        // given
        val newPerson = Person(first = "David", last = "Romero")

        // when
        newPerson.sayHello()

        // then
        verifyTheMessageHasBeenPrinted()
    }


    private fun verifyTheMessageHasBeenPrinted() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}