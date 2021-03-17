package com.github.hotire.springbootkotlin.test.junit5

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ParameterizedTestTest {

    companion object {
        @JvmStatic
        fun squares() = listOf(
            Arguments.of(1, 1),
            Arguments.of(2, 4)
        )
    }

    @ParameterizedTest
    @MethodSource("squares")
    fun testSquares(input: Int, expected: Int) {
        // when
        val result = input * input

        // then
        assertThat(result).isEqualTo(expected)
    }
}