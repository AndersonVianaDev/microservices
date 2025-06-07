package com.anderson.email_service.domain.dtos;

import java.io.Serializable;

public record WelcomeMessageDTO(String name, String email) implements Serializable {
}
