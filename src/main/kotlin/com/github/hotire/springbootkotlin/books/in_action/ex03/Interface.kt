package com.github.hotire.springbootkotlin.books.in_action.ex03

interface Clickable {
    fun click()
    fun showOff() = println("click")
}

interface Focusable {
    fun focus()
    fun showOff() = println("focus")
}

class Button : Clickable, Focusable {

    override fun click() {
    }

    override fun focus() {
    }

    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }
}
