package com.github.hotire.springbootkotlin.delegate

import kotlin.reflect.KProperty

class MyDelegate {
    operator fun getValue(thisRef: Any, property: KProperty<*>): String = "hello"
}

class C { val prop: String by MyDelegate() }
