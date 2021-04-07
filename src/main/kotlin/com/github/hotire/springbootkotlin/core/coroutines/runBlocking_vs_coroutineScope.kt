package com.github.hotire.springbootkotlin.core.coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * runBlocking과 coroutineScope의 주요 차이점은 모든 자식이 완료되x기를 기다리는 동안 현재 스레드를 차단하지 않는다는 것입니다.
 *
 * runBlocking is not a suspend fun
 * coroutineScope is a suspend fun.
 *
 * coroutineScope에서는 자식 스레드가 완료될 때 까지 현재 스레드를 block 하지 않는다.
 * runBlocking에서는 자식 스레드가 완료될 때 까지 현재 스레드를 block 한다.
 *
 *
 */
fun main() = runBlocking { // this: CoroutineScope
    launch {
        println("Task start runBlocking : " + Thread.currentThread().name)
        delay(200L)
        println("Task from runBlocking : " + Thread.currentThread().name)
    }

    /**
     * runBlocking is for you to block the main thread.
     * coroutineScope is for you to block the runBlocking.
     *
     * https://eso0609.tistory.com/82
     * coroutineScope -> async && await ??
     */
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
