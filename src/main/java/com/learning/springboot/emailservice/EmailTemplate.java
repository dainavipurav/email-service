package com.learning.springboot.emailservice;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EmailTemplate {
    SIMPLE_EMAIL_TEMPLATE("simple", "Simple Email"),
    NEW_COURSE_PROMOTION_EMAIL_TEMPLATE("new-course-promo-email-template", "Special Promotion"),
    INSTRUCTOR_REGISTRATION_EMAIL_TEMPLATE("instructor-registration-email-template", "Welcome to the Academy"),
    STUDENT_REGISTRATION_EMAIL_TEMPLATE("student-registration-email-template", "Registration Confirmed"),
    INFO_EMAIL_TEMPLATE("info", "Information");

    private final String templateName;
    private final String subject;
}
