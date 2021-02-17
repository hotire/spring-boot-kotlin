package com.github.hotire.springbootkotlin.books.in_action.ex03

import java.lang.StringBuilder

fun <T> joinToString(collection: Collection<T>, separator: String, prefix: String, postfix: String): String {
    val result = StringBuilder(prefix)
    for ((index, el) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(el)
    }
    result.append(postfix)
    return result.toString()
}

fun main(args: Array<String>) {
    print(joinToString(listOf(1, 2, 3), ":", "(", ")"))
}
