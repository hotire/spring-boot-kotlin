package com.github.hotire.springbootkotlin.core.coroutines

class SimpleThread : Thread() {
    override fun run() {
        println("${Thread.currentThread()} has run.")
    }
}

class SimpleRunnable : Runnable {
    override fun run() {
        println("${Thread.currentThread()} has run.")
    }
}

fun main() {
    val thread = SimpleThread()
    thread.start()

    val threadWithRunnable = Thread(SimpleRunnable())
    threadWithRunnable.start()
}
