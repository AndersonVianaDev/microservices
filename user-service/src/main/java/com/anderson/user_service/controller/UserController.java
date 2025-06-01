package com.anderson.user_service.controller;

import com.anderson.user_service.controller.dtos.request.UpdateRequestDTO;
import com.anderson.user_service.controller.dtos.request.UserRequestDTO;
import com.anderson.user_service.controller.dtos.response.UserResponseDTO;
import com.anderson.user_service.domain.model.User;
import com.anderson.user_service.domain.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final IUserService service;

    @PostMapping
    public ResponseEntity<UserResponseDTO> create(@RequestBody UserRequestDTO request) {
        final User user = service.create(UserRequestDTO.of(request));

        return ResponseEntity.status(HttpStatus.CREATED).body(UserResponseDTO.from(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable UUID id) {
        final User user = service.findById(id);

        return ResponseEntity.ok(UserResponseDTO.from(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponseDTO> delete(@PathVariable UUID id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> update(@PathVariable UUID id, @RequestBody UpdateRequestDTO request) {
        final User user = service.update(id, UpdateRequestDTO.of(request));

        return ResponseEntity.ok(UserResponseDTO.from(user));
    }

}
