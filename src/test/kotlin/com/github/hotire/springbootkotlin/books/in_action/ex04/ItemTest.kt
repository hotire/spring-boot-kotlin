package com.github.hotire.springbootkotlin.books.in_action.ex04

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ItemTest {

    @Test
    fun alias() {
        // given
        val expected = "test"
        val item = Item("")

        // when
        item.alias = expected

        // then
        assertThat(item.alias).isEqualTo(expected)
    }
}
