package com.sobia.library_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${app.frontend.url}")
    private String frontendUrl;

    public void sendPasswordResetEmail(String toEmail, String token) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Library System — Password Reset Request");
        message.setText(
                "Hello,\n\n" +
                        "You requested a password reset for your Library System account.\n\n" +
                        "Click the link below to reset your password:\n" +
                        frontendUrl + "/reset-password?token=" + token + "\n\n" +
                        "This link will expire in 1 hour.\n\n" +
                        "If you did not request this, please ignore this email.\n\n" +
                        "Library Management System"
        );
        mailSender.send(message);
    }

    public void sendWelcomeEmail(String toEmail, String firstName, String password) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Welcome to Library Management System");
        message.setText(
                "Hello " + firstName + ",\n\n" +
                        "Your account has been created in the Library Management System.\n\n" +
                        "Your login credentials:\n" +
                        "Email: " + toEmail + "\n" +
                        "Password: " + password + "\n\n" +
                        "Please login at: " + frontendUrl + "/login\n\n" +
                        "We recommend changing your password after first login.\n\n" +
                        "Library Management System"
        );
        mailSender.send(message);
    }
}
