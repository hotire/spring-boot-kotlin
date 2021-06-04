package com.github.hotire.springbootkotlin.utils.log

import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test

internal class KLoggerDelegateTest {

    val log by KLoggerDelegate()

    @Test
    fun getValue() {
        println(log.hashCode())
        println(log.hashCode())

        log.info { "hello" }
    }
}