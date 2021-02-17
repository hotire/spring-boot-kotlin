package com.github.hotire.springbootkotlin.books.in_action.ex04

object Payroll {
    val names = arrayListOf<String>()

    fun print() {
        print(names)
    }
}

fun main(args: Array<String>) {
    Payroll.names.add("hotire")
    Payroll.print()
}
