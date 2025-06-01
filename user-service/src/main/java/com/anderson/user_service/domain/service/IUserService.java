package com.anderson.user_service.domain.service;

import com.anderson.user_service.domain.model.User;

import java.util.UUID;

public interface IUserService {
    User create(User user);
    User findById(UUID id);
    void delete(UUID id);
    User update(UUID id, User user);
}
