package com.github.hotire.springbootkotlin.books.in_action.ex11

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DependencyHandlerTest {

    @Test
    fun compile() {
        // given
        val dependency = "test"
        val dependencyHandler = DependencyHandler()

        // when
        dependencyHandler.compile(dependency)
        val result = dependencyHandler.dependencies

        // then
        assertThat(result).contains(dependency)
    }

    @Test
    fun invoke() {
        // given
        val dependency = "test"
        val dependencyHandler = DependencyHandler()

        // when
        dependencyHandler {
            compile(dependency)
        }
        val result = dependencyHandler.dependencies

        // then
        assertThat(result).contains(dependency)
    }
}
