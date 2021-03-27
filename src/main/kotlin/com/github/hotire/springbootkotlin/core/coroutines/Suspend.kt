package com.github.hotire.springbootkotlin.core.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    testRunFunction()
}

fun testRunFunction() {
    // Start a coroutine
    GlobalScope.launch {
        println("In start : ${Thread.currentThread().name}")
        Thread.sleep(200)
        println("In ended : ${Thread.currentThread().name}")
    }

    run {
        println("Out start: ${Thread.currentThread().name}")
        Thread.sleep(300)
        println("Out ended: ${Thread.currentThread().name}")
    }

    Thread.sleep(300)
    println("clear")

    runBlocking {
        // Start a coroutine
        launch(coroutineContext) {
            println("In start : ${Thread.currentThread().name}")
            Thread.sleep(200)
            println("In ended : ${Thread.currentThread().name}")
        }

        run {
            println("Out start: ${Thread.currentThread().name}")
            Thread.sleep(300)
            println("Out ended: ${Thread.currentThread().name}")
        }
    }

    Thread.sleep(300)
    println("clear")

    runBlocking {
        // Start a coroutine
        launch(coroutineContext) {
            println("In start : ${Thread.currentThread().name}")
            delay(300)
            println("In ended : ${Thread.currentThread().name}")
        }

        run {
            println("Out start: ${Thread.currentThread().name}")
            delay(300)
            println("Out ended: ${Thread.currentThread().name}")
        }
    }
}
