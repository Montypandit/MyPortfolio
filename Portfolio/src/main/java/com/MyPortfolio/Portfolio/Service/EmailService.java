package com.MyPortfolio.Portfolio.Service;

// public class EmailService {

// }

// package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    @Autowired
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;  // Inject JavaMailSender
    }

    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("monty29550@gmail.com");  // Sender's email
        message.setTo(to);                       // Recipient's email
        message.setSubject(subject);             // Email subject
        message.setText(body);                   // Email body/content
        mailSender.send(message);                // Send the email
    }
}

