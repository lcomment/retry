package com.example.resilience4j.controller

import com.example.resilience4j.service.Resilience4jRetryTestService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/retry-test")
@RestController
class Resilience4jRetryTestController(
    private val retryTestService: Resilience4jRetryTestService
) {

    @GetMapping
    fun retryTest(): String {
        retryTestService.execute()
        return "Retry test executed successfully"
    }
}
