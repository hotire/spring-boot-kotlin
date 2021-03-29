package com.github.hotire.springbootkotlin.core.coroutines.client

import com.github.hotire.springbootkotlin.log.LoggerDelegate
import org.springframework.stereotype.Component

@Component
class TestClient {
    val log by LoggerDelegate()

    fun getInternal(url: String): String {
        log.info(Thread.currentThread().name)
        Thread.sleep(3000L)
        return url
    }
}
