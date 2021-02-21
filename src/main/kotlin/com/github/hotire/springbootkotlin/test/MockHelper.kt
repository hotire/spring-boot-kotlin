package com.github.hotire.springbootkotlin.test

import org.mockito.Mockito.mock
import org.springframework.beans.factory.annotation.Autowired
import kotlin.reflect.KClass
import kotlin.reflect.cast
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.hasAnnotation

data class MockHelper(val mockMap: MutableMap<KClass<*>, Any> = mutableMapOf()) {
    fun clear() = mockMap.clear()

    inline fun <reified T : Any> createInstanceWithMock(type: KClass<T>): T {
        return mockMap[type]?.let { T::class.cast(it) } ?: kotlin.run {
            type.declaredMemberProperties.filter { it.hasAnnotation<Autowired>() }

            // TODO
            return mock(type.java)
        }
    }

    inline fun <reified T : Any> getMock(type: KClass<T>): T {
        return mockMap[type]?.let { T::class.cast(it) } ?: kotlin.run {
            val mock = mock(type.java)
            mockMap[type] = mock
            return mock
        }
    }

    // TODO
    fun <T> createInstance(type: KClass<T>): T {
//        type.constructors.map {
//            return it.call(it.typeParameters.map { it. } })
//        }
    }
}
