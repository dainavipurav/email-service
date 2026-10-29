package com.learning.springboot.emailservice.controller;

import com.learning.springboot.emailservice.EmailTemplate;
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
@RequestMapping("/api")
public class EmailController {

    private final EmailService emailService;

    @PostMapping("/email")
    public SuccessResponseDto sendEmail(@Valid @RequestBody EmailRequestDto request){
        return emailService.sendEmail(request);
    }

    @PostMapping("/templateEmail")
    public SuccessResponseDto sendTemplateEmail(@RequestParam String to,
                                                @RequestParam EmailTemplate emailTemplate,
                                                @RequestBody Map<String, Object> variables){
        return emailService.sendHtmlTemplateEmail(to, emailTemplate.getSubject(), emailTemplate.getTemplateName(), variables);
    }
}
