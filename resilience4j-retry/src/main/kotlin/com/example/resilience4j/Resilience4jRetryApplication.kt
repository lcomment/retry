package com.example.resilience4j

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Resilience4jRetryApplication

fun main(args: Array<String>) {
    runApplication<Resilience4jRetryApplication>(*args)
}
