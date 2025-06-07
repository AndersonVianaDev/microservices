package com.anderson.email_service.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailSenderService {

    private final JavaMailSender mailSender;

    public void sendWelcomeEmail(String to, String name) {
        var message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Welcome to our platform!");
        message.setText("Hello " + name + ",\n\nThanks for registering. We're happy to have you on board!");

        mailSender.send(message);
        log.info("Welcome email sent to {}", to);
    }
}
