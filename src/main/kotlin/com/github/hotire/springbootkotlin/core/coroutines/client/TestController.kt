package com.github.hotire.springbootkotlin.core.coroutines.client

import com.github.hotire.springbootkotlin.log.LoggerDelegate
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.newFixedThreadPoolContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.slf4j.MDCContext
import kotlinx.coroutines.withContext
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.coroutines.CoroutineContext
import kotlin.system.measureTimeMillis

object ClientCoroutineScope : CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + MDCContext()
}

@RestController
@RequestMapping("/v1/test")
class TestController(private val testClient: TestClient) {

    val log by LoggerDelegate()

    @GetMapping
    fun get(): List<String> {
        val result = runBlocking {
            listOf(
                async(Dispatchers.IO) {
                    testClient.getInternal("a")
                },
            ).awaitAll()
        }

        log.info("hello")

        val deferred = listOf(
            ClientCoroutineScope.async { testClient.getInternal("a") },
            ClientCoroutineScope.async { testClient.getInternal("b") }
        )

        val result2 = runBlocking {
            deferred.awaitAll()
        }

        log.info("hello2")

        return result
    }

    @GetMapping("/2")
    fun get2() = measureTimeMillis {
        val dispatcher = newFixedThreadPoolContext(2, "withc")
        runBlocking {
            withContext(dispatcher) {
                testClient.getInternal("b")
            }
            withContext(dispatcher) {
                testClient.getInternal("b")
            }
        }
    }
}
