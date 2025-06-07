package com.anderson.user_service.infra.aws.producer;

import com.anderson.user_service.domain.dtos.WelcomeMessageDTO;
import com.anderson.user_service.domain.service.IMessagePublisher;
import com.anderson.user_service.infra.exceptions.UnexpectedException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    public void sendToWelcomeQueue(WelcomeMessageDTO message) {
        try {
            final String json = new ObjectMapper().writeValueAsString(message);
            sqsTemplate.send(WELCOME_QUEUE, json);
        } catch (Exception e) {
            throw new UnexpectedException("Error sending to welcome queue");
        }

    }
}
