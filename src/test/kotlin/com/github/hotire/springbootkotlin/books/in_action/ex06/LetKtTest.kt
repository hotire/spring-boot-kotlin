package com.github.hotire.springbootkotlin.books.in_action.ex06

import org.junit.jupiter.api.Test

internal class LetKtTest {
    @Test
    fun ifPresent() {
        val s = "abc"
        ifPresent(s) { println(it) }
    }
}
