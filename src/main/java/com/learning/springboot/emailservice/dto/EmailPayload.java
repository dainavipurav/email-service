package com.learning.springboot.emailservice.dto;

import com.learning.springboot.emailservice.EmailTemplate;

import java.util.Map;

public interface EmailPayload {
    String recipient();
    String subject();
    EmailTemplate emailTemplate();           // e.g., "student-registration", "course-announcement"
    Map<String, Object> templateVariables(); // Model map passed directly to Thymeleaf
}
