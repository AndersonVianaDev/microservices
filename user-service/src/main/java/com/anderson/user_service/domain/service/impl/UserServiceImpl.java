package com.anderson.user_service.domain.service.impl;

import com.anderson.user_service.domain.dtos.MessageEventDTO;
import com.anderson.user_service.domain.enums.EventType;
import com.anderson.user_service.domain.model.User;
import com.anderson.user_service.domain.service.IMessagePublisher;
import com.anderson.user_service.domain.service.IUserService;
import com.anderson.user_service.infra.exceptions.DataConflictException;
import com.anderson.user_service.infra.exceptions.NotFoundException;
import com.anderson.user_service.infra.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static java.util.Objects.nonNull;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final UserRepository repository;
    private final IMessagePublisher messagePublisher;

    @Override
    public User create(User user) {
        if (repository.findByEmail(user.getEmail()).isPresent()) {
            throw new DataConflictException("User already registered");
        }

        user = repository.save(user);

        messagePublisher.sendToWelcomeQueue(
                new MessageEventDTO(
                        user.getName(),
                        user.getEmail(),
                        EventType.USER_REGISTERED
                ));

        return user;
    }

    @Override
    public User findById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }

    @Override
    public void delete(UUID id) {
        final User user = this.findById(id);

        repository.delete(user);
    }

    @Override
    public User update(UUID id, User user) {
        final User userSaved = this.findById(id);

        if(nonNull(user.getEmail())) {
            userSaved.setEmail(user.getEmail());
        }

        if(nonNull(user.getName())) {
            userSaved.setName(user.getName());
        }

        return repository.save(userSaved);
    }
}
