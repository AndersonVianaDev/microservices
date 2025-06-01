package com.anderson.user_service.controller.dtos.request;

import com.anderson.user_service.domain.model.User;

public record UpdateRequestDTO(String name, String email) {
    public static User of(UpdateRequestDTO request) {
        return User.builder()
                .name(request.name())
                .email(request.email())
                .build();
    }
}
