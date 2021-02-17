package com.github.hotire.springbootkotlin.books.in_action.ex10

import kotlin.reflect.KClass

interface ValueSerializer<T> {
    fun toJson(value: T): String?
    fun fromJson(json: String): T?
}

@Target(AnnotationTarget.PROPERTY)
annotation class CustomSerializer(
    val serializerClass: KClass<out ValueSerializer<*>>
)
