package com.github.hotire.springbootkotlin.books.in_action.ex03

fun String.lastChar(): Char = get(length - 1)

fun main(args: Array<String>) {
    val s = "abc"
    print(s.lastChar())
}
