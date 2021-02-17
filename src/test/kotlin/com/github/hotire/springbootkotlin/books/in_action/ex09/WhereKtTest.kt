package com.github.hotire.springbootkotlin.books.in_action.ex09

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WhereKtTest {
    @Test
    fun ensureTrailingPeriod() {
        // given
        val sb = StringBuilder("abc")

        // when
        ensureTrailingPeriod(sb)

        // then
        assertThat(sb.last()).isEqualTo(',')
    }
}
