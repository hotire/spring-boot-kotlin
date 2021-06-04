package com.github.hotire.springbootkotlin.log

import org.junit.jupiter.api.Test

internal class KLoggerDelegateTest {

    val log by KLoggerDelegate()

    @Test
    fun getValue() {
        // no assert
        log.info { "hello" }
    }
}
