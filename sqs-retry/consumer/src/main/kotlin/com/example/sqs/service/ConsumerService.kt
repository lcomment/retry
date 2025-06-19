package com.example.sqs.service

import io.awspring.cloud.sqs.annotation.SqsListener
import io.awspring.cloud.sqs.listener.acknowledgement.Acknowledgement
import org.springframework.stereotype.Service

@Service
class ConsumerService {

    @SqsListener(value = ["\${sqs.mq}"])
    fun sqsListener(message: String, ack: Acknowledgement) {
        try {
            val random = (1..10).random()
            if (random <= 5) {
                throw RuntimeException("Simulated failure for message: $message")
            }

            ack.acknowledgeAsync()
        } catch (e: RuntimeException) {
            println("Error: " + e.message)
        }
    }

    @SqsListener(value = ["\${sqs.dlq}"])
    fun dlqListener(message: String, ack: Acknowledgement) {
        try {
            val random = (1..10).random()
            if (random <= 3) {
                throw RuntimeException("Simulated failure for message: $message")
            }

            ack.acknowledgeAsync()
        } catch (e: Exception) {
            println("Error: " + e.message)
        }
    }
}
