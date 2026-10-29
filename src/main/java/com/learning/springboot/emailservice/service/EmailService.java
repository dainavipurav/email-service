package com.learning.springboot.emailservice.service;

import com.learning.springboot.emailservice.dto.EmailRequestDto;
import com.learning.springboot.emailservice.dto.SuccessResponseDto;

public interface EmailService {

    SuccessResponseDto sendEmail(EmailRequestDto request);
}
