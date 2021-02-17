package com.github.hotire.springbootkotlin.books.in_action.ex10

import org.springframework.util.SerializationUtils.serialize
import java.io.Serializable

data class Person(val name: String, val age: Int) : Serializable

fun main() {
    val person = Person("hotire", 1)

    val json = serialize(person)

    println(json)
}
