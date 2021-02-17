package com.github.hotire.springbootkotlin.books.in_action.ex09

class Processor<T : Any> {
    fun process(value: T) {
        value.hashCode()
    }
}
