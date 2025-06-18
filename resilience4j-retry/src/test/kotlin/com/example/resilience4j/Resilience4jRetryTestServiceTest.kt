package com.example.resilience4j

import com.example.resilience4j.service.Resilience4jRetryTestService
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class Resilience4jRetryTestServiceTest {

    @Autowired
    private lateinit var service: Resilience4jRetryTestService

    @Test
    fun `attempts three times`() {
        service.execute()

        service.getCounter() shouldBe 4
    }
}
