package com.springboot.SupportFlowLite.mapper;

import com.springboot.SupportFlowLite.dto.TicketReqDto;
import com.springboot.SupportFlowLite.model.Ticket;

public class TicketMapper {
    public static Ticket mapDtoToEntity(TicketReqDto dto) {
        Ticket ticket = new Ticket();
        ticket.setType(dto.type());
        ticket.setSubject(dto.subject());
        ticket.setDetails(dto.details());
        return ticket;
    }
}
