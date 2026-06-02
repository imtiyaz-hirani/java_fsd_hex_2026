package com.springboot.SupportFlowLite.dto;

import com.springboot.SupportFlowLite.enums.TicketType;
import jakarta.validation.constraints.NotBlank;

public record TicketReqDto(
        TicketType type,
        @NotBlank
        String subject,
        String details
) {
}
