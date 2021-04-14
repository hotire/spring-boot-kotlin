package com.github.hotire.springbootkotlin.core.coroutines.coroutine_scheduler

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

/**
 * @see kotlinx.coroutines.Dispatchers.IO
 * @see kotlinx.coroutines.Dispatchers.Default
 * IO / Default 는 동일한 executor == coroutineScheduler 사용하고
 * 구현체는 CoroutineScheduler를 사용한다.
 */
fun main() {
    /**
     * @see kotlinx.coroutines.scheduling.CoroutineScheduler.dispatch()
     */
    GlobalScope.async(Dispatchers.Default) {
        println("hello : ${Thread.currentThread().name}")

        // notAdded is null
        GlobalScope.async(Dispatchers.Default) {
            println("hello : ${Thread.currentThread().name}")
        }
    }
}
