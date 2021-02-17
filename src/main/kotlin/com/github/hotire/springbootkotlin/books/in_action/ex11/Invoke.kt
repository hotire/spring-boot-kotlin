package com.github.hotire.springbootkotlin.books.in_action.ex11

class DependencyHandler {
    val dependencies = mutableListOf<String>()

    fun compile(coordinate: String) {
        dependencies.add(coordinate)
        println("Add dependency on $coordinate")
    }

    operator fun invoke(body: DependencyHandler.() -> Unit) {
        body()
    }
}
