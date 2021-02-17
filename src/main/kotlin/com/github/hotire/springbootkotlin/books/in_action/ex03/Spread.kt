package com.github.hotire.springbootkotlin.books.in_action.ex03

fun main(args: Array<String>) {
    var list = listOf("a", *args)
    print(list)
}
