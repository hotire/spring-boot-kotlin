package com.github.hotire.springbootkotlin.books.in_action.ex04

class Account(val name: String) {
    var address: String = "undefined"
        set(value: String) {
            println("$field -> $value".trimIndent())
            field = value
        }
}

fun main(args: Array<String>) {
    val account = Account("hotire")
    account.address = "Seoul"
}
