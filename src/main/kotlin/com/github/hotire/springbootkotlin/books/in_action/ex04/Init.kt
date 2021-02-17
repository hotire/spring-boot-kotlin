package com.github.hotire.springbootkotlin.books.in_action.ex04

class User constructor(name: String) {
    val name: String

    init {
        this.name = name
    }
}

class View {
    constructor(name: String) {
    }
    constructor(name: String, count: Int) {
    }

    init {
        println("init1")
    }
    init {
        println("init2")
    }
}

fun main(args: Array<String>) {
    val user = User("hotire")
    println(user)

    val view = View("hotire")
}
