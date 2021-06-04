package com.github.hotire.springbootkotlin.log

import mu.KotlinLogging
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class LoggerDelegate : ReadOnlyProperty<Any?, Logger> {

    private val logger2 = KotlinLogging.logger {}

    companion object {
        private fun <T> createLogger(clazz: Class<T>): Logger {
            return LoggerFactory.getLogger(clazz)
        }
    }

    private var logger: Logger? = null

    override operator fun getValue(thisRef: Any?, property: KProperty<*>): Logger {
        if (logger == null) {
            logger = createLogger(thisRef!!.javaClass)
        }
        logger!!
        return logger!!
    }
}
