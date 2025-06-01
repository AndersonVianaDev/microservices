package com.anderson.user_service.controller.dtos.request;

import com.anderson.user_service.domain.model.User;

public record UserRequestDTO(String name, String email, String document) {
    public static User of(UserRequestDTO request) {
        return User.builder()
                .name(request.name())
                .email(request.email())
                .document(request.document())
                .build();
    }
}
