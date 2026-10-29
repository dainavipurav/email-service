package com.learning.springboot.emailservice.dto;

import com.learning.springboot.emailservice.EmailTemplate;

import java.util.Map;

public class StudentRegistrationEmailDto implements EmailPayload{

    String recipient;
    String studentName;
    String courseName;
    String registrationDate;
    String studentStatus;

    @Override
    public String recipient() {
        return recipient;
    }

    @Override
    public String subject() {
        return EmailTemplate.STUDENT_REGISTRATION_EMAIL_TEMPLATE.getSubject() + studentName;
    }

    @Override
    public EmailTemplate emailTemplate() {
        return EmailTemplate.STUDENT_REGISTRATION_EMAIL_TEMPLATE;
    }

    @Override
    public Map<String, Object> templateVariables() {
        return Map.of(
                "studentName", studentName,
                "courseName", courseName,
                "registrationDate", registrationDate,
                "studentStatus", studentStatus
        );
    }
}
