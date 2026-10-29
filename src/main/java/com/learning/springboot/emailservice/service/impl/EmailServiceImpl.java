package com.learning.springboot.emailservice.service.impl;

import com.learning.springboot.emailservice.dto.EmailRequestDto;
import com.learning.springboot.emailservice.dto.SuccessResponseDto;
import com.learning.springboot.emailservice.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;
    private final SpringTemplateEngine templateEngine;

    @Value("${spring.mail.username}")
    private String fromEmailId;

    @Override
    public SuccessResponseDto sendEmail(EmailRequestDto request) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(fromEmailId);
        simpleMailMessage.setTo(request.getToEmailId());
        simpleMailMessage.setSubject(request.getSubject() == null ? "Default Email" : request.getSubject());
        simpleMailMessage.setText(request.getMessage());

        javaMailSender.send(simpleMailMessage);

        return SuccessResponseDto.builder()
                .status(HttpStatus.OK.value())
                .message("Email sent successfully")
                .timestamp(LocalDateTime.now())
                .build();
    }

    @Override
    public SuccessResponseDto sendHtmlTemplateEmail(
            String to,
            String subject,
            String templateName,
            Map<String, Object> variables) {

        try {
            Context context = new Context();
            context.setVariables(variables);

            String processedHtml =
                    templateEngine.process(templateName, context);

            MimeMessage message = javaMailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(
                    message,
                    MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name()
            );

            helper.setTo(to);
            helper.setFrom(fromEmailId);
            helper.setSubject(subject);
            helper.setText(processedHtml, true);

            javaMailSender.send(message);

        } catch (MessagingException ex) {
            // Log the exception using a structured logger (e.g., SLF4J/Logback).
            throw new RuntimeException(
                    "Failed to send template email: " + templateName,
                    ex
            );
        }

        return SuccessResponseDto.builder()
                .status(HttpStatus.OK.value())
                .message("Email sent successfully")
                .timestamp(LocalDateTime.now())
                .build();
    }
}
