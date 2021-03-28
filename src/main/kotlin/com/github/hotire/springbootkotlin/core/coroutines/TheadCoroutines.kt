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
