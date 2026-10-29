package com.learning.springboot.emailservice.service.impl;

import com.learning.springboot.emailservice.dto.EmailRequestDto;
import com.learning.springboot.emailservice.dto.SuccessResponseDto;
import com.learning.springboot.emailservice.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;

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
}
