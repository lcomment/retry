package com.example.resilience4j.config

import io.github.resilience4j.core.IntervalFunction
import io.github.resilience4j.retry.RetryConfig
import io.github.resilience4j.retry.RetryRegistry
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Resilience4jRetryConfig {

    @Bean
    fun retryRegistry(): RetryRegistry {
        return RetryRegistry.of(
            RetryConfig.custom<Any>()
                .maxAttempts(3)
                .intervalFunction(
                    IntervalFunction.ofExponentialBackoff(
                        1000L,
                        2.0,
                        5000L
                    )
                )
                .retryExceptions(RuntimeException::class.java)
                .ignoreExceptions(IllegalArgumentException::class.java)
                .build()
        )
    }
}
