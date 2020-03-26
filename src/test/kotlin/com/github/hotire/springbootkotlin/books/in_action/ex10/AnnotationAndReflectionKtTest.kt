package com.github.hotire.springbootkotlin.books.in_action.ex10

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AnnotationAndReflectionKtTest {
    @Test
    fun getHash() {
        // given
        val person = PersonEntity("hello", 2)

        // when
        val result = person.getHash()

        // then
        assertThat(result).isEqualTo("PersonEntity1hello, PersonEntity22");
    }
}