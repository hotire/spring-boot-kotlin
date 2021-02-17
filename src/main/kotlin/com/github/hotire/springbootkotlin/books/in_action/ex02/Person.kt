package com.github.hotire.springbootkotlin.books.in_action.ex02

class Person(
    val name: String,
    var isMarried: Boolean
) {
    val isNotMarried: Boolean
        get() {
            return !this.isMarried
        }
}

fun main(args: Array<String>) {
    val person = Person("hello", false)
    print(person.name)
    person.isMarried = true
    print(person.isMarried)
    print(person.isNotMarried)
}
