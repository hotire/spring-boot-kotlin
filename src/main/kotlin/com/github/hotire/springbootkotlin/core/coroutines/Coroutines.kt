package com.github.hotire.springbootkotlin.core.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class Coroutines

fun main() {
    GlobalScope.launch { // 백그라운드에서 작업하는 새로운 코루틴
        println("start 1") // 딜레이 후 프린트
        delay(1000L) // non-blocking한 1초 딜레이
        println("World! 1") // 딜레이 후 프린트
    }
    println("Hello, 1") // 코루틴이 딜레이를 주는 동안 메인 스레드는 계속 실행 중
    Thread.sleep(3000L) // JVM의 작업을 유지하기 위해 메인 스레드를 2초간 블록

    GlobalScope.launch {
        delay(3000L)
        println("World! 2.4")
    }
    println("Hello, 2") // 메인 스레드를 바로 지속됨.
    runBlocking { // 하지만 여기에서 메인스레드가 블록된다.
        println("Hello, 2.1") // 메인 스레드를 바로 지속됨.
        delay(1000L)
        println("Hello, 2.2") // 메인 스레드를 바로 지속됨.
    }
    println("Hello, 2.3")

    Thread.sleep(3000L) // JVM의 작업을 유지하기 위해 메인 스레드를 2초간 블록

    runBlocking { // main 코루틴 시작
        GlobalScope.launch {
            delay(1000L)
            println("World! 3")
        }
        println("Hello, 3")
        delay(2000L)
    }

    Thread.sleep(3000L)

    runBlocking {
        launch {
            delay(200L)
            println("Task from runBlocking")
        }

        //  coroutineScope builder를 사용하여 자신만의 스코프를 선언할 수 있습니다.
        //  이것은 코루틴의 범위를 만들고 모든 하위 launch들이 완료될 때까지 완료되지 않습니다.
        coroutineScope { // 코루틴 스코프 생성
            launch {
                delay(500L)
                println("Task from nested launch")
            }

            delay(100L)
            println("Task from coroutine scope") // 이 라인은 nested launch가 출력되기 전에 실행됩니다.
        }

        launch {
            delay(200L)
            println("Task from runBlocking2")
        }

        println("Coroutine scope is over") // 이 라인은 하위 launch가 완료되기 전까지 실행되지 않습니다.
    }

    runBlocking {
// 시작
        GlobalScope.launch {
            repeat(1000) { i ->
                println("I'm sleeping $i ...")
                delay(500L)
            }
        }
        delay(1300L) // 지연 후 종료
// 끝
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
