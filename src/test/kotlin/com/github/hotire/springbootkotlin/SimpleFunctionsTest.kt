package com.github.hotire.springbootkotlin

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.Arrays

class SimpleFunctionsTest {
    /**
     * the function start return the string "OK".
     */
    private fun start(): String = "OK"

    @Test
    fun test_start() {
        assertThat(start()).isEqualTo("OK")
    }

    /**
     * It can be called on a collection of Strings. Specifying only two arguments make the function joinOptions()
     * return the list in a JSON format (e.g., "[a, b, c]")
     */
    private fun joinOptions(options: Collection<String>): String =
        options.joinToString(prefix = "[", postfix = "]")

    @Test
    fun test_joinOptions() {
        assertThat(joinOptions(Arrays.asList("a", "b", "c"))).isEqualTo("[a, b, c]")
    }
}
