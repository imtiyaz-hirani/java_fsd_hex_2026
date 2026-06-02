package com.springboot.SupportFlowLite.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CustomerReqDto(
        @NotBlank(message = "name is mandatory")
        @NotNull
        @Size(max = 255)
        String name,
        @NotBlank
        @NotNull
        @Email
        String email,
        @NotBlank
        @NotNull
        @Size(min = 10, max = 10)
        String phoneNumber,
        @NotBlank
        @NotNull
        String username,
        @NotBlank
        @NotNull
        String password

) {
}
