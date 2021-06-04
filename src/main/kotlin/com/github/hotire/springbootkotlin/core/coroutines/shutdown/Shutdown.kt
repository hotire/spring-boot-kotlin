package com.github.hotire.springbootkotlin.core.coroutines.shutdown

import com.github.hotire.springbootkotlin.log.LoggerDelegate
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.asExecutor
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.slf4j.MDCContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.core.task.TaskExecutor
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.io.Closeable
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import kotlin.coroutines.CoroutineContext

@RestController
class ShutdownController {

    @Autowired
    private lateinit var dispatcher: CoroutineDispatcher
    @Autowired
    private lateinit var coroutineScope: CoroutineScope

    val log by LoggerDelegate()

    @GetMapping("/shutdown")
    fun shutdown() {
        CoroutineScope(Dispatchers.Default + MDCContext()).async {
            log.info("start : ${Thread.currentThread().name}")
            delay(5000L)
            log.info("end hello : ${Thread.currentThread().name}")
        }
    }

    @GetMapping("/shutdown2")
    fun shutdown2() {

        coroutineScope.async {
            log.info("start2 : ${Thread.currentThread().name}")
            Thread.sleep(3000L)
            runCatching { Thread.sleep(5000L) }.also {
                log.info("end2 hello : ${Thread.currentThread().name}")
            }
        }

//        CoroutineScope(dispatcher).async {
//            log.info("start : ${Thread.currentThread().name}")
//            Thread.sleep(5000L)
//            log.info("end hello : ${Thread.currentThread().name}")
//        }

        CoroutineScope(dispatcher).async {
            log.info("start2 : ${Thread.currentThread().name}")
            runCatching { Thread.sleep(5000L) }.also {
                log.info("end2 hello : ${Thread.currentThread().name}")
            }
        }
    }

    @Bean
    fun threadPool(): TaskExecutor {
        val taskExecutor = ThreadPoolTaskExecutor()
        taskExecutor.corePoolSize = 10
        taskExecutor.setAwaitTerminationSeconds(10)
        taskExecutor.setWaitForTasksToCompleteOnShutdown(true)
        return taskExecutor
    }

    @Bean
    fun dispatcher(threadPool: TaskExecutor): CoroutineDispatcher {
        return threadPool.asCoroutineDispatcher()
    }

    @Bean
    fun executorCoroutineScope(): CoroutineScope = object : CoroutineScope {
        override val coroutineContext: CoroutineContext
            get() = dispatcher(threadPool())
    }
}

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
