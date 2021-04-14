package com.github.hotire.springbootkotlin.core.coroutines.coroutine_scheduler

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

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
