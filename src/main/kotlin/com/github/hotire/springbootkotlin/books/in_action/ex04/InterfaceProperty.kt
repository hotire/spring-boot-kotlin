package com.github.hotire.springbootkotlin.books.in_action.ex04

interface Service {
    val name: String
}

// 생성자
class UserService(override val name: String) : Service

// getter
class BookService(private val book: String) : Service {
    override val name: String
        get() = book
}
