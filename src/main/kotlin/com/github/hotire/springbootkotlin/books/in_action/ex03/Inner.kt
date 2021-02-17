package com.github.hotire.springbootkotlin.books.in_action.ex03

class Outer {
    var name: String? = null

    class StaticInner {
        var age: Int? = 0
        fun toOuter(name: String): Outer {
            val outer = Outer()
            outer.name = name
            return outer
        }
    }

    inner class Inner {
        fun outReference(): Outer = this@Outer
    }
}

fun main(args: Array<String>) {
    val outer = Outer()
    val staticInner = Outer.StaticInner()
    staticInner.toOuter("hello")

    val inner = outer.Inner()
    inner.outReference()
}
