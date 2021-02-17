package com.github.hotire.springbootkotlin.books.in_action.ex06

import java.util.function.Consumer

fun ifPresent(obj: Any?, consumer: Consumer<Any>) {
    obj ?.let { it -> consumer.accept(it) }
}

fun ifPresent(obj: Any?, consumer: (Any) -> Unit) {
    obj ?.let { it -> consumer(it) }
}
