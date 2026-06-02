package com.springboot.SupportFlowLite.dto;

import com.springboot.SupportFlowLite.enums.TicketStatus;
import com.springboot.SupportFlowLite.enums.TicketType;

import java.time.Instant;

public record TicketRespDto(
        Long id,
        String subject,
        TicketType type,
        TicketStatus status,
        Instant createdAt,
        String handledBy
) {
}
