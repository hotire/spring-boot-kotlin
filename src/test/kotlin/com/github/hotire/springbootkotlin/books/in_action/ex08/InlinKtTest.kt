package com.github.hotire.springbootkotlin.books.in_action.ex08

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InlinKtTest {

    @Test
    fun lock() {
        // given
        val expected = "hello"

        // when
        val result = synchronized { expected }

        // then
        assertThat(result).isEqualTo(expected)
    }
}
