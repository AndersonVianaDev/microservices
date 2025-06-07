package com.anderson.user_service.domain.service;

import com.anderson.user_service.domain.dtos.WelcomeMessageDTO;

public interface IMessagePublisher {
    void sendToWelcomeQueue(WelcomeMessageDTO message);
}
