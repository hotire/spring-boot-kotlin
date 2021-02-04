package com.github.hotire.springbootkotlin.core

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CatchTest {

    @Test
    fun ifEmpty() {
        // given
        val list = listOf<String>()
        val expected: String = "a"

        // when
        val result = list.ifEmpty { listOf(expected) }

        // then
        assertThat(result).contains(expected)
    }

    @Test
    fun orEmpty() {

    }

    @Test
    fun requireNoNulls() {

    }

    @Test
    fun listOfNotNull() {

    }
}