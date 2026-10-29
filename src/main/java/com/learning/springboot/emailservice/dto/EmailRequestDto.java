package com.learning.springboot.emailservice.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailRequestDto {

    @NotNull(message = "Email id is required")
    @NotBlank(message = "Email id cannot be empty")
    @Email(message = "Please provide a valid email")
    @Size(max = 50)
    private String toEmailId;

    @NotNull(message = "Message is required")
    @NotBlank(message = "Message cannot be empty")
    private String message;

    private String subject;
}
