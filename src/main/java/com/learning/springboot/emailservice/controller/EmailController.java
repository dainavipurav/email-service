package com.learning.springboot.emailservice.controller;

import com.learning.springboot.emailservice.EmailTemplate;
import com.learning.springboot.emailservice.dto.EmailPayload;
import com.learning.springboot.emailservice.dto.EmailRequestDto;
import com.learning.springboot.emailservice.dto.SuccessResponseDto;
import com.learning.springboot.emailservice.service.EmailService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping("/v1/email")
public class EmailController {

    private final EmailService emailService;

    @PostMapping
    public SuccessResponseDto sendEmail(@Valid @RequestBody EmailRequestDto request){
        return emailService.sendEmail(request);
    }

    @PostMapping
    public SuccessResponseDto sendTemplateEmail(String to, String subject, EmailTemplate emailTemplate, Map<String, Object> variables){
        return emailService.sendHtmlTemplateEmail(to, subject, emailTemplate.getTemplateName(), variables);
    }

    /*"imismail885@gmail.com", "Email from great Dainavi Purav", "student-registration-email-template", Map.of(
            "studentName", "Ismail",
            "courseName", "Algebra",
            "registrationDate", "12/10/2026",
            "studentStatus", "ENROLLED"
            )*/
}
