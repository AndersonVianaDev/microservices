package com.anderson.user_service.controller;

import com.anderson.user_service.infra.exceptions.DataConflictException;
import com.anderson.user_service.infra.exceptions.NotFoundException;
import com.anderson.user_service.infra.exceptions.StandardException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionController {


    @ExceptionHandler(DataConflictException.class)
    public ResponseEntity<StandardException> dataConflict(DataConflictException e, HttpServletRequest request) {
        final String error = "data conflict";
        final HttpStatus status = HttpStatus.CONFLICT;
        final StandardException err = StandardException.builder()
                .error(error)
                .status(status.value())
                .timestamp(LocalDateTime.now())
                .path(request.getRequestURI())
                .message(e.getMessage())
                .build();

        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardException> notFound(NotFoundException e, HttpServletRequest request) {
        final String error = "not found";
        final HttpStatus status = HttpStatus.NOT_FOUND;
        final StandardException err = StandardException.builder()
                .error(error)
                .status(status.value())
                .timestamp(LocalDateTime.now())
                .path(request.getRequestURI())
                .message(e.getMessage())
                .build();

        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandardException> exception(Exception e, HttpServletRequest request) {
        final String error = "internal server error";
        final HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        final StandardException err = StandardException.builder()
                .error(error)
                .status(status.value())
                .timestamp(LocalDateTime.now())
                .path(request.getRequestURI())
                .message(e.getMessage())
                .build();

        return ResponseEntity.status(status).body(err);
    }

}
