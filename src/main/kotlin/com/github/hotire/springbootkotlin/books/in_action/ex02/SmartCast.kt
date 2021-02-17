package com.github.hotire.springbootkotlin.books.in_action.ex02

interface Expr

class Num(val value: Int) : Expr

class Sum(val num1: Expr, val num2: Expr) : Expr

fun main(args: Array<String>) {
    print(eval(Sum(Num(1), Num(2))))
}

fun eval(e: Expr): Int {
    return when (e) {
        is Num -> e.value
        is Sum -> eval(e.num1) + eval(e.num2)
        else -> throw IllegalArgumentException("$e")
    }
}
