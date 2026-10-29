package com.learning.springboot.emailservice.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PromotionalEmailDto  {
    private String courseName;
    private int courseId;
    private String instructorName;
    private double courseFees;
}
