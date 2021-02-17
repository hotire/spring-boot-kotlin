package com.github.hotire.springbootkotlin.books.in_action.ex04

class Item(val name: String) {
    var alias: String = "undefined"
        set(value: String) {
            println("$field -> $value")
            field = value
        }
}
