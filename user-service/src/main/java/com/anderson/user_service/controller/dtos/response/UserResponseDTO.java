package com.anderson.user_service.controller.dtos.response;

import com.anderson.user_service.domain.model.User;

import java.util.UUID;

public record UserResponseDTO(UUID id, String name, String email, String document) {
    public static UserResponseDTO from(User user) {
        return new UserResponseDTO(user.getId(), user.getName(), user.getEmail(), user.getDocument());
    }
}
