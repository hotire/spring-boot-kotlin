package com.github.hotire.springbootkotlin.core.coroutines.shutdown

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.asExecutor
import kotlinx.coroutines.async
import java.io.Closeable
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

fun main() {
    val threadPool = Executors.newFixedThreadPool(4)
    threadPool.awaitTermination(10L, TimeUnit.SECONDS)
    val dispatcher = threadPool.asCoroutineDispatcher()

    CoroutineScope(dispatcher).async {
        println("hello : ${Thread.currentThread().name}")
    }
    threadPool.shutdown()

    val default = Dispatchers.Default
    val close = default.asExecutor()

    if (close is Closeable) {
        close.close()
    }
}
