package com.github.hotire.springbootkotlin.core.coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking { // this: CoroutineScope
    launch {
        delay(200L)
        println("Task from runBlocking : " + Thread.currentThread().name)
    }

    coroutineScope { // Creates a new coroutine scope
        launch {
            delay(900L)
            println("Task from nested launch : " + Thread.currentThread().name)
        }

        delay(100L)
        println("Task from coroutine scope : " + Thread.currentThread().name) // This line will be printed before nested launch
    }

    println("Coroutine scope is over : " + Thread.currentThread().name) // This line is not printed until nested launch completes
}
