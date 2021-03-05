package com.github.hotire.springbootkotlin.core.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class Coroutines

fun main() {
    GlobalScope.launch { // 백그라운드에서 작업하는 새로운 코루틴
        delay(1000L) // non-blocking한 1초 딜레이
        println("World! 1") // 딜레이 후 프린트
    }
    println("Hello, 1") // 코루틴이 딜레이를 주는 동안 메인 스레드는 계속 실행 중
    Thread.sleep(2000L) // JVM의 작업을 유지하기 위해 메인 스레드를 2초간 블록

    GlobalScope.launch {
        delay(1000L)
        println("World! 2")
    }
    println("Hello, 2") // 메인 스레드를 바로 지속됨.
    runBlocking { // 하지만 여기에서 메인스레드가 블록된다.
        delay(2000L)
    }

    runBlocking { // main 코루틴 시작
        GlobalScope.launch {
            delay(1000L)
            println("World! ")
        }
        println("Hello, 3")
        delay(2000L)
    }
}


fun join() = runBlocking {
    // 시작
    val job = GlobalScope.launch { // 새로운 코루틴을 시작하고 job에 대한 참조를 유지한다.
        delay(1000L)
        println("World!")
    }
    println("Hello,")
    job.join() // 하위 코루틴이 완료될 때까지 기다린다.
    // 끝
}


