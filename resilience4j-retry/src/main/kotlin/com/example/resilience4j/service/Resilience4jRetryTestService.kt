package com.example.resilience4j.service

import io.github.resilience4j.retry.annotation.Retry
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class Resilience4jRetryTestService {

    private var counter: Int = 1

    @Retry(name = "test-retry", fallbackMethod = "fallback")
    fun execute() {
        logger.info("Retry Testing #{} : #{}", counter++, System.currentTimeMillis().toString())

        if (counter < 4) {
            logger.debug("attempt #{}", counter)
            throw RuntimeException("Simulated failure for testing")
        }

        logger.debug("successfully executed after {} attempts", counter)
    }

    fun fallback(e: Throwable) {
        logger.info("Fallback Method")
    }

    fun getCounter(): Int {
        return counter
    }

    companion object {
        private val logger = LoggerFactory.getLogger(Resilience4jRetryTestService::class.java)
    }
}
