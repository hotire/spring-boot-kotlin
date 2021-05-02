package com.github.hotire.springbootkotlin.extensions

class D {
    fun bar() { println("D.bar()") }
}
class C {
    fun baz() { println("C.bar()") }
    fun D.foo() { // class C valid
        bar() // calls D.bar
        baz() // calls C.baz
        toString() // call D.toString()
        this@C.toString() // call C.toString()
    }
    fun caller(d: D) {
        d.foo() // call the extension function
    }
}

fun main() {
    C().baz()
//    D().foo()  // compile error
}
