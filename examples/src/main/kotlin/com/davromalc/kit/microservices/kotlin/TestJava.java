package com.davromalc.kit.microservices.kotlin;

public class TestJava {

    public void Given_a_new_person_When_the_person_say_hello_Then_a_message_is_printed(){
        // given
        Person person = new Person("David", "Romero");

        // when
        person.sayHello();

        // then
        verifyTheMessageHasBeenPrinted();
    }

    private void verifyTheMessageHasBeenPrinted() {
    }

}
