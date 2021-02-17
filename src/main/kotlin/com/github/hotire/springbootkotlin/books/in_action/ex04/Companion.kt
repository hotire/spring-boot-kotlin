package com.github.hotire.springbootkotlin.books.in_action.ex04

class A {
    companion object {
        fun bar() {
        }
    }
}

class B {
    companion object Name {
        fun naming() {
        }
    }
}

interface JSONFactory<T> {
    fun fromJSON(text: String): T
}

class C {
    companion object : JSONFactory<C> {
        override fun fromJSON(text: String): C {
            return C()
        }
    }
}

fun main(args: Array<String>) {
    A.bar()
    B.Name.naming()
    C.fromJSON("")
}
