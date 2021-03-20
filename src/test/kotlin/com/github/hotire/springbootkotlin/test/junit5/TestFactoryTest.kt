package com.github.hotire.springbootkotlin.test.junit5

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

/**
 * https://github.com/gradle/gradle/issues/5975
 */
internal class TestFactoryTest {
    @TestFactory
    fun testSquares() = listOf(
        1 to 1,
        2 to 4,
        3 to 9,
        4 to 16,
        5 to 25
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("when I calculate $input^2 then I get $expected") {
            assertThat(input * input).isEqualTo(expected)
        }
    }
}
