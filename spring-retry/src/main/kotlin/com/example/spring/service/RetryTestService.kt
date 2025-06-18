package com.example.spring.service

import org.slf4j.LoggerFactory
import org.springframework.retry.annotation.Backoff
import org.springframework.retry.annotation.Retryable
import org.springframework.stereotype.Service

@Service
class RetryTestService {

    private var counter: Int = 1

    @Retryable(
        maxAttempts = 3,
        backoff = Backoff(
            delay = 1000,         // 첫 재시도까지 대기 시간 (ms)
            multiplier = 2.0,     // 지수 증가 배수
            maxDelay = 5000       // 최대 대기 시간
        ),
        include = [RuntimeException::class]
    )
    fun execute() {
        logger.info("Retry Testing #{} : #{}", counter++, System.currentTimeMillis().toString())

        if (counter < 4) {
            logger.debug("attempt #{}", counter)
            throw RuntimeException("Simulated failure for testing")
        }

        logger.debug("successfully executed after {} attempts", counter)
    }

    fun getCounter(): Int {
        return counter
    }

    companion object {
        private val logger = LoggerFactory.getLogger(RetryTestService::class.java)
    }
}
