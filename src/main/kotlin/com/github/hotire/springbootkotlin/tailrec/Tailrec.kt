package com.github.hotire.springbootkotlin.tailrec

// -> stackOverflowError
private fun factorial(n: Long): Long {
    return if (n == 1L) n
    else n * factorial(n - 1)
}

// 재귀 함수는 재귀 호출이 함수에 의해 마지막으로 실행되는 경우 꼬리 재귀 입니다.
private tailrec fun factorialTailrec(n: Long, answer: Long): Long {
    return if (n == 1L) n
    else factorialTailrec(n - 1, answer * n)
}

fun main() {
    factorial(10000)
    factorialTailrec(10000)
}
