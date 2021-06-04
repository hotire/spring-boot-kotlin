package com.github.hotire.springbootkotlin.utils.log

import mu.KLogger
import mu.KotlinLogging
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class KLoggerDelegate : ReadOnlyProperty<Any?, KLogger> {

    override operator fun getValue(thisRef: Any?, property: KProperty<*>): KLogger {
        return KotlinLogging.logger(thisRef!!.javaClass.name)
    }
}
