package com.github.hotire.springbootkotlin.core.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Coroutines

fun main() {
    GlobalScope.launch { // 백그라운드에서 작업하는 새로운 코루틴
        delay(1000L) // non-blocking한 1초 딜레이
        println("World!") // 딜레이 후 프린트
    }
    println("Hello,") // 코루틴이 딜레이를 주는 동안 메인 스레드는 계속 실행 중
    Thread.sleep(2000L) // JVM의 작업을 유지하기 위해 메인 스레드를 2초간 블록
}
