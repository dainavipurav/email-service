package com.learning.springboot.emailservice.service;

import com.learning.springboot.emailservice.dto.EmailRequestDto;
import com.learning.springboot.emailservice.dto.SuccessResponseDto;

import java.util.Map;

public interface EmailService {

    SuccessResponseDto sendEmail(EmailRequestDto request);

    SuccessResponseDto sendHtmlTemplateEmail(String to, String subject, String templateName, Map<String, Object> variables);
}
