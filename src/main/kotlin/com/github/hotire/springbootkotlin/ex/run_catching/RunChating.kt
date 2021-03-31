package com.github.hotire.springbootkotlin.ex.run_catching

fun main() {
    var media = "hello2"
    val result = runCatching {
        "hello"
    }.onFailure {
        println(it)
    }.onSuccess {
        println(it)
        media = it
    }.getOrNull()

    println(result)
}
