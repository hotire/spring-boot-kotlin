package com.github.hotire.springbootkotlin.books.in_action.ex03

infix fun Any.to(other: Any) = Pair(this, other)

fun main(args: Array<String>) {
    val (number, name) = 1 to "one"
    println(number)
    println(name)
}
