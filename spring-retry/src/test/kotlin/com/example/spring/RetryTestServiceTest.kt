package com.example.spring

import com.example.spring.service.RetryTestService
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class RetryTestServiceTest {

    @Autowired
    private lateinit var service: RetryTestService

    @Test
    fun `attempts three times`() {
        try {
            service.execute()
        } catch (e: RuntimeException) {
             // ignored
        }

        service.getCounter() shouldBe 4
    }
}
