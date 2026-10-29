package com.learning.springboot.emailservice.controller;

import com.learning.springboot.emailservice.dto.EmailRequestDto;
import com.learning.springboot.emailservice.dto.SuccessResponseDto;
import com.learning.springboot.emailservice.service.EmailService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
