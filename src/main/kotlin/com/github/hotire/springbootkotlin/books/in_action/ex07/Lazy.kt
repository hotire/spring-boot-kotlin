package com.github.hotire.springbootkotlin.books.in_action.ex07

class Person(val name: String) {
    val email by lazy { initEmail() }
    private fun initEmail(): String = "hello"
}
