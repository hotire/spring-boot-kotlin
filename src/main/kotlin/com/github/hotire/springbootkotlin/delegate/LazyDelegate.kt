package com.github.hotire.springbootkotlin.delegate


class LazyDelegate {

    var name: String? = null

    val text: MutableMap<String, String> by lazy {
        println("init")
        val map = mutableMapOf("a" to "b")
        map
    }
}

fun main() {
    val lazyDelegate = LazyDelegate()
    println("before")
    lazyDelegate.name = "hotire"
    println(lazyDelegate.text)
    lazyDelegate.text["b"] = "c"
    println("after")
    lazyDelegate.name = "hotire2"
    println(lazyDelegate.text)
}
