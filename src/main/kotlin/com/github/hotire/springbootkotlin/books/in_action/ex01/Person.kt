package com.github.hotire.springbootkotlin.books.in_action.ex01

data class Person(val name: String, val age: Int? = null)

fun main(args: Array<String>) {
    val persons = listOf(Person("tire"), Person("ho", age = 29))

    val oldest = persons.maxBy { it.age ?: 0 }
    print("max : $oldest")
}
