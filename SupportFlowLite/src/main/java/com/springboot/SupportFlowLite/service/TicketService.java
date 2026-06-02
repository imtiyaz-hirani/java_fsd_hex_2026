package com.springboot.SupportFlowLite.service;

import com.springboot.SupportFlowLite.dto.TicketReqDto;
import com.springboot.SupportFlowLite.enums.TicketStatus;
import com.springboot.SupportFlowLite.mapper.TicketMapper;
import com.springboot.SupportFlowLite.model.Customer;
import com.springboot.SupportFlowLite.model.Ticket;
import com.springboot.SupportFlowLite.repository.TicketRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TicketService {

    private final CustomerService customerService;
    private final TicketRepository ticketRepository;

    public void add( TicketReqDto dto, String customerUsername) {
        // Step 1: Map dto to Ticket Entity
        Ticket ticket =  TicketMapper.mapDtoToEntity(dto);

        // Step 2: Fetch Customer from customerUsername
        Customer customer = customerService.getByUsername(customerUsername);

        // Step 3: Check for any fields that need to be assigned.
        ticket.setStatus(TicketStatus.OPEN);

        // Step 4: Attach Customer to Ticket
        ticket.setCustomer(customer);

        // Step 5: Save ticket in DB
        ticketRepository.save(ticket);

    }
}
