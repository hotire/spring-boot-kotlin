package com.github.hotire.springbootkotlin

import com.github.hotire.springbootkotlin.utils.log.KLoggerDelegate
import org.springframework.stereotype.Service
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/log")
class LoggerController(private val loggerService: LoggerService) {

    @GetMapping("/hello")
    fun log() {
        loggerService.hello()
    }
}

@Validated
@Service
class LoggerService {
    private val log by KLoggerDelegate()

    fun hello() {
        log.info("")
        log.info { "hello" }
    }
}
