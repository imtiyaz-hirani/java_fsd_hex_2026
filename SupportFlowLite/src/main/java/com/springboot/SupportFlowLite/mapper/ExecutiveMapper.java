package com.springboot.SupportFlowLite.mapper;

import com.springboot.SupportFlowLite.dto.TicketExecutiveResponseDto;
import com.springboot.SupportFlowLite.model.Ticket;

public class ExecutiveMapper {

    public static TicketExecutiveResponseDto mapEntityToDto(Ticket ticket){
        return new TicketExecutiveResponseDto(
                ticket.getId(),
                ticket.getSubject(),
                ticket.getType(),
                ticket.getStatus(),
                ticket.getCreatedAt(),
                ticket.getCustomer()==null?"Ticket closed": ticket.getCustomer().getName()
         );
    }
}
