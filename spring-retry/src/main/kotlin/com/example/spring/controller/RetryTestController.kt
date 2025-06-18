package com.example.spring.controller

import com.example.spring.service.RetryTestService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/retry-test")
@RestController
class RetryTestController(
    private val retryTestService: RetryTestService
) {

    @GetMapping
    fun retryTest(): String {
        retryTestService.execute()
        return "Retry test executed successfully"
    }
}
