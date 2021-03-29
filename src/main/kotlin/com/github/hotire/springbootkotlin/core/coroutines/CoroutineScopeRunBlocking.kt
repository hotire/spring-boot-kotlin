package com.github.hotire.springbootkotlin.core.coroutines

import com.github.hotire.springbootkotlin.log.LoggerDelegate
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


suspend fun main() {

    coroutineScope {
        launch {
            println("2")
        }

        println("3")
    }

    runBlocking {
        launch {
            println("1")
        }
    }
}
