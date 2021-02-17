package com.github.hotire.springbootkotlin.books.in_action.ex03

import java.lang.RuntimeException

class User(var name: String, var address: String)

fun save(user: User) {
    fun validate(value: String, fieldName: String) {
        if (value.isBlank()) {
            throw RuntimeException("Can't save user, empty $fieldName")
        }
    }
    validate(user.name, "name")
    validate(user.name, "address")

    // save
}

fun main(args: Array<String>) {
    val user = User("hotire", "seoul")
    save(user)
}
