package com.github.hotire.springbootkotlin.books.in_action.ex02

enum class Color {
    RED, ORANGE, BLUE
}

fun main(args: Array<String>) {
    print(convert(Color.BLUE))
}

fun convert(color: Color): String =
    when (color) {
        Color.RED -> "1"
        Color.ORANGE -> "2"
        Color.BLUE -> "3"
    }
