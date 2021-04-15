package com.github.hotire.springbootkotlin.delegate

class LazyDelegate {
    val text by lazy {
        println("init")
        "hello"
    }
}


fun main() {
    val lazyDelegate = LazyDelegate()
    println("before")
    lazyDelegate.text
    println("after")
    lazyDelegate.text
}