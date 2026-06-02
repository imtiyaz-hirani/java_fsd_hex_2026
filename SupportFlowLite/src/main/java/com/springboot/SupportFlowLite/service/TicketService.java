package com.springboot.SupportFlowLite.service;

import com.springboot.SupportFlowLite.dto.TicketExecutiveResponseDto;
import com.springboot.SupportFlowLite.dto.TicketReqDto;
import com.springboot.SupportFlowLite.dto.TicketRespDto;
import com.springboot.SupportFlowLite.enums.TicketStatus;
import com.springboot.SupportFlowLite.execptions.ResourceNotFoundException;
import com.springboot.SupportFlowLite.mapper.ExecutiveMapper;
import com.springboot.SupportFlowLite.mapper.TicketMapper;
import com.springboot.SupportFlowLite.model.Customer;
import com.springboot.SupportFlowLite.model.Executive;
import com.springboot.SupportFlowLite.model.Ticket;
import com.springboot.SupportFlowLite.repository.TicketRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TicketService {

    private final CustomerService customerService;
    private final TicketRepository ticketRepository;
    private final ExecutiveService executiveService;

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

    public List<TicketRespDto> getTicketsByCustomer(int page, int size, String customerUsername) {
        // Step 1: Pagination
       Pageable pageable =  PageRequest.of(page,size);

       // Step 2: JPQL
       List<Ticket> list = ticketRepository.getTicketsByCustomer(customerUsername, pageable).getContent();

       // Step 3: Covert to Dto using Mapper : convert Ticket entity to TicketRespDto
        return list.stream()
                .map(TicketMapper :: mapEntityToDto)
                .toList();
    }

    public void assignTicketToExecutive(int executiveId, int ticketId) {
        // Step 1: Fetch Executive using executiveId
        Executive executive =  executiveService.getById(executiveId);
        // Step 2: Fetch Ticket by ticketId
        Ticket ticket = getById(ticketId);
        // Step 3: Attach executive to Ticket : assign
        ticket.setExecutive(executive);
        // Step 4: Re-save the ticket
        ticketRepository.save(ticket);
    }

    public Ticket getById(int ticketId) {
        return ticketRepository.findById(ticketId)
                .orElseThrow(()-> new ResourceNotFoundException("Invalid Ticket Id"));
    }

    public List<TicketExecutiveResponseDto> getTicketsByExecutive(String executiveUsername, int page, int size) {
        // Step 1: Pagination
        Pageable pageable =  PageRequest.of(page,size);

        // Step 2: JPQL
        List<Ticket> list  = ticketRepository.getTicketsByExecutive(executiveUsername, pageable).getContent();


        // Step 3: Covert to Dto using Mapper : convert Ticket entity to TicketExecutiveRespDto
         return list.stream()
                 .map(ExecutiveMapper :: mapEntityToDto)
                 .toList();
    }
}
