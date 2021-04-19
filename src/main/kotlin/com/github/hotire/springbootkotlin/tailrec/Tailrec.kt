package com.github.hotire.springbootkotlin.tailrec

// -> stackOverflowError
private fun factorial(n: Long): Long {
    return if (n == 1L) n
    else n * factorial(n - 1)
}

// 재귀 함수는 재귀 호출이 함수에 의해 마지막으로 실행되는 경우 꼬리 재귀 입니다.
private tailrec fun factorialTailrec(n: Long, answer: Long = 1): Long {
    return if (n == 1L) {
        println(answer)
        return n
    } else factorialTailrec(n - 1, answer * n)
}

fun main() {
    println(factorial(10L))
    println(factorialTailrec(10L))
}
