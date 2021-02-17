package com.github.hotire.springbootkotlin

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FunctionsTest {

    @Test
    fun sum() {
        assertThat(sum(1, 3)).isEqualTo(4)
    }

    @Test
    fun inferredSum() {
        assertThat(inferredSum(1, 3)).isEqualTo(4)
    }

    private fun sum(a: Int, b: Int): Int {
        return a + b
    }

    private fun inferredSum(a: Int, b: Int) = a + b
}
