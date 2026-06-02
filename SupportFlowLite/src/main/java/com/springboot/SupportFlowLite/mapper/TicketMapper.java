package com.springboot.SupportFlowLite.mapper;

import com.springboot.SupportFlowLite.dto.TicketReqDto;
import com.springboot.SupportFlowLite.dto.TicketRespDto;
import com.springboot.SupportFlowLite.model.Ticket;

public class TicketMapper {
    public static Ticket mapDtoToEntity(TicketReqDto dto) {
        Ticket ticket = new Ticket();
        ticket.setType(dto.type());
        ticket.setSubject(dto.subject());
        ticket.setDetails(dto.details());
        return ticket;
    }

    public static  TicketRespDto mapEntityToDto(Ticket ticket){
        String handledBy = "No Executive Assigned Yet";
        if(ticket.getExecutive() != null){
            handledBy = ticket.getExecutive().getName();
        }
        return new TicketRespDto(ticket.getId(),
                ticket.getSubject(),
                ticket.getType(),
                ticket.getStatus(),
                ticket.getCreatedAt(),
                handledBy
                //ticket.getExecutive() == null?"No Executive Assigned Yet": ticket.getExecutive().getName()
                );
    }
}
