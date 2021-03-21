package com.github.hotire.springbootkotlin.test

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MockHelperTest {

    class Service {
        fun get(): String = "a"
    }

    @Test
    fun clear() {
        // given
        val mockHelper = MockHelper()

        // when
        mockHelper.mockMap[Service::class] = Service()
        mockHelper.clear()

        // then
        assertThat(mockHelper.mockMap).isEmpty()
    }
}
