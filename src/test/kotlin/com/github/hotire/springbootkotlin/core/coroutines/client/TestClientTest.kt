package com.github.hotire.springbootkotlin.core.coroutines.client

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.junit.jupiter.api.Test

internal class TestClientTest {

    @Test
    fun getInternal() {
        val testClient = TestClient()
        val url = "url"

        val result = runBlocking {
            listOf(
                async {
                    withContext(Dispatchers.IO) {
                        testClient.getInternal(url)
                    }
                },
                async {
                    withContext(Dispatchers.IO) {
                        testClient.getInternal(url)
                    }
                }
            ).awaitAll()
        }

        // then
        print(result)
    }
}
