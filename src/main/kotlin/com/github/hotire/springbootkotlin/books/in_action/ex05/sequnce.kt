package com.github.hotire.springbootkotlin.books.in_action.ex05

fun main(args: Array<String>) {
    val numbers = generateSequence(0) { it + 1 }
    val sum = numbers.takeWhile { it <= 100 }.sum()
    println(sum)
}
