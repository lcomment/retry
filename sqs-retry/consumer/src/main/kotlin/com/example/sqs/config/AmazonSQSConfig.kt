package com.example.sqs.config

import io.awspring.cloud.sqs.config.SqsMessageListenerContainerFactory
import io.awspring.cloud.sqs.listener.acknowledgement.handler.AcknowledgementMode
import io.awspring.cloud.sqs.operations.SqsTemplate
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import software.amazon.awssdk.services.sqs.SqsAsyncClient

@Configuration
class AmazonSQSConfig(
    private val sqsAsyncClient: SqsAsyncClient
) {

    @Bean
    fun defaultSqsListenerContainerFactory(sqsAsyncClient: SqsAsyncClient): SqsMessageListenerContainerFactory<Any?> {
        return SqsMessageListenerContainerFactory
            .builder<Any>()
            .configure { it.acknowledgementMode(AcknowledgementMode.MANUAL) } // 수동 ACK 설정
            .sqsAsyncClient(sqsAsyncClient)
            .build()
    }

    @Bean
    fun sqsTemplate(): SqsTemplate {
        return SqsTemplate.newTemplate(sqsAsyncClient)
    }
}
