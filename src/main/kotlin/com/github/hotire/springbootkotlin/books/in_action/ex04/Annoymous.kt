package com.github.hotire.springbootkotlin.books.in_action.ex04

interface Event {
    fun click()
}

fun main(args: Array<String>) {
    event(object : Event {
        var count = 0
        override fun click() {
            ++count
            println("click $count")
        }
    })
}

fun event(event: Event) {
    event.click()
}
