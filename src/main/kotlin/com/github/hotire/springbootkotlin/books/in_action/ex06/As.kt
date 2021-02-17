package com.github.hotire.springbootkotlin.books.in_action.ex06

fun isString(obj: Any): Boolean {
    val other = obj as? String ?: return false
    return true
}
