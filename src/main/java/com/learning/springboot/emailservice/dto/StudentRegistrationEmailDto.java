package com.learning.springboot.emailservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentRegistrationEmailDto {

    private String recipient;

    private String studentName;

    private String courseName;

    private LocalDate registrationDate;

    private String studentStatus;
}
