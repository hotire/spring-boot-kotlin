package com.github.hotire.springbootkotlin.books.in_action.ex06

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AsKtTest {
    @Test
    fun isString() {
        // given
        val s = "abc"

        // when
        val result = com.github.hotire.springbootkotlin.books.in_action.ex06.isString(s)

        // then
        assertThat(result).isEqualTo(true)
    }
}
