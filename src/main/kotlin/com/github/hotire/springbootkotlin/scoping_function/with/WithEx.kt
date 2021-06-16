package com.github.hotire.springbootkotlin.scoping_function.with

class Person {
    var name: String? = null
    var age: Int? = null
}

fun main() {
    val person: Person = Person()
    println(person.name)
    println(person.age)

    with(person) {
        println(name)
        println(age)
    }
}
