package com.example.sqs.controller

import io.awspring.cloud.sqs.operations.SqsTemplate
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.function.Consumer

@RequestMapping("/api/retry-test")
@RestController
class SqsProduceController(
    private val sqsTemplate: SqsTemplate,
) {

    private val queue: String = "test-sqs.fifo"
    private var counter: Int = 1

    @GetMapping
    fun retryTest(): String {
        sqsTemplate.send<String>(Consumer {
            it.queue(queue).payload("Hello World")
        })
        logger.debug("successfully executed after {} attempts", counter)

        return "Retry test executed successfully"
    }

    companion object {
        private val logger = LoggerFactory.getLogger(SqsProduceController::class.java)
    }
}
