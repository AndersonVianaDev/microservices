package com.anderson.user_service.domain.service;

import com.anderson.user_service.domain.dtos.MessageEventDTO;

public interface IMessagePublisher {
    void sendToWelcomeQueue(MessageEventDTO message);
}
