package com.github.hotire.springbootkotlin.core.coroutines.client

import com.github.hotire.springbootkotlin.utils.log.LoggerDelegate
import org.springframework.stereotype.Component

@Component
class TestClient {
    val log by LoggerDelegate()

    fun getInternal(url: String): String {
        log.info(Thread.currentThread().name)
        Thread.sleep(4000L)
        log.info("suc " + Thread.currentThread().name)
        return url
    }
}
