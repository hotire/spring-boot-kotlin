package com.github.hotire.springbootkotlin.books.in_action.ex10

import kotlin.reflect.full.findAnnotation

class Reflection(val name: String)

fun main() {
    val reflection = Reflection("")
    val c = Reflection::class.java.kotlin
    reflection.javaClass.kotlin

    val custom = Reflection::class.findAnnotation<CustomSerializer>()
    Reflection::class.java.declaredFields
}

// fun <T : Annotation> KAnnotatedElement.findAnnotation2(): T? =
//        @Suppress("UNCHECKED_CAST")
//        annotations.firstOrNull { it is T } as T?
