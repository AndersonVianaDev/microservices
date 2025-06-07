package com.anderson.user_service.domain.dtos;

import java.io.Serializable;

public record WelcomeMessageDTO(String name, String email) implements Serializable {
}
