package com.anderson.user_service.domain.dtos;

import com.anderson.user_service.domain.enums.EventType;

import java.io.Serializable;

public record MessageEventDTO(String name, String email, EventType type) implements Serializable {
}
