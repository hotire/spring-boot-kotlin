package com.github.hotire.springbootkotlin.scoping_function.also

class Person {
    var name: String? = null
    var age: Int? = null
}

fun main() {
    val person: Person = Person()

    val result = person.also { it.age = 1 }

    println(person)
}
