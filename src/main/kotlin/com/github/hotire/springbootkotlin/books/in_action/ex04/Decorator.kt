package com.github.hotire.springbootkotlin.books.in_action.ex04

class CountingSet<T> (
    val innerSet: MutableCollection<T> = HashSet<T>()
) : Collection<T> by innerSet
