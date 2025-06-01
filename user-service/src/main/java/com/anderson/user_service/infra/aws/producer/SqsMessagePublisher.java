package com.anderson.user_service.infra.aws.producer;

import com.anderson.user_service.domain.dtos.MessageEventDTO;
import com.anderson.user_service.domain.service.IMessagePublisher;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SqsMessagePublisher implements IMessagePublisher {

    @Value("${spring.aws.queue.welcome_queue}")
    private String WELCOME_QUEUE;

    private final SqsTemplate sqsTemplate;

    @Override
    public void sendToWelcomeQueue(MessageEventDTO message) {
        sqsTemplate.send(WELCOME_QUEUE, message);
    }
}
