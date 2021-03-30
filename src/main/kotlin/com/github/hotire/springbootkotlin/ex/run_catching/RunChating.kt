package com.github.hotire.springbootkotlin.ex.run_catching

fun main() {
    runCatching {
        if (1 == 1) throw RuntimeException()
        "hello"
    }.onFailure {
        println(it)
    }.onSuccess {
        println(it)
    }
}
