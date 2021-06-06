# Log

롬북을 사용하지 못해.. 불편한 로깅..

## Idiomatic Logging in Kotlin
https://www.baeldung.com/kotlin/logging

## MicroUtils/kotlin-logging

https://github.com/MicroUtils/kotlin-logging

### KotlinLogging

~~~kotlin
actual object KotlinLogging {
    /**
     * This method allow defining the logger in a file in the following way:
     * ```
     * val logger = KotlinLogging.logger {}
     * ```
     */
    actual fun logger(func: () -> Unit): KLogger = KLoggerFactory.logger(func)

    actual fun logger(name: String): KLogger = KLoggerFactory.logger(name)

    fun logger(underlyingLogger: Logger) = KLoggerFactory.wrapJLogger(underlyingLogger)
}

fun Logger.toKLogger() = KotlinLogging.logger(this)

~~~

각 플랫폼별 actual class 를 통하여 실제 구현을 하도록 합니다.

~~~kotlin
actual fun logger(name: String): KLogger = KLoggerFactory.logger(name) 
~~~
-> KLoggerFactory
~~~kotlin
internal inline fun logger(name: String): KLogger = wrapJLogger(jLogger(name))
~~~
~~~kotlin
private inline fun jLogger(name: String): Logger = LoggerFactory.getLogger(name)
~~~
