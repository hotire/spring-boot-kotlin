package com.github.hotire.springbootkotlin.books.in_action.ex08

import java.util.concurrent.locks.ReentrantLock

inline fun <T> synchronized(action: () -> T): T {
    val lock = ReentrantLock()
    try {
        lock.lock()
        return action()
    } finally {
        lock.unlock()
    }
}
