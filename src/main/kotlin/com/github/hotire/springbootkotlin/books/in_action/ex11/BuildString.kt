package com.github.hotire.springbootkotlin.books.in_action.ex11

// 확장함수가 맞는건가??
fun buildString(action: StringBuilder.() -> Unit): String = StringBuilder().apply(action).toString()
