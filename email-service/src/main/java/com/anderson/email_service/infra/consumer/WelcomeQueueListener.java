package com.anderson.email_service.infra.consumer;

import com.anderson.email_service.application.EmailSenderService;
import com.anderson.email_service.domain.dtos.WelcomeMessageDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class WelcomeQueueListener {

    private final EmailSenderService emailSenderService;
    private final ObjectMapper objectMapper;

    @SqsListener("${spring.aws.queue.welcome-queue}")
    public void listen(String messageJSON) {
        try {
            WelcomeMessageDTO message = objectMapper.readValue(messageJSON, WelcomeMessageDTO.class);

            emailSenderService.sendWelcomeEmail(message.email(), message.name());
        } catch (Exception e) {
            log.error("Error processing message from queue", e);
        }
    }

}
