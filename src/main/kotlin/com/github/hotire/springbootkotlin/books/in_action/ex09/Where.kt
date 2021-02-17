package com.github.hotire.springbootkotlin.books.in_action.ex09

fun <T> ensureTrailingPeriod(seq: T) where T : CharSequence, T : Appendable {
    if (seq.isNotEmpty()) {
        seq.append(',')
    }
}
