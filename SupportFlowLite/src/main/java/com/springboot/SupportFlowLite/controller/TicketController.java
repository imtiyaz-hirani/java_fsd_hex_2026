package com.springboot.SupportFlowLite.controller;

import com.springboot.SupportFlowLite.dto.TicketExecutiveResponseDto;
import com.springboot.SupportFlowLite.dto.TicketReqDto;
import com.springboot.SupportFlowLite.dto.TicketRespDto;
import com.springboot.SupportFlowLite.service.TicketService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/ticket")
public class TicketController {

    private final TicketService ticketService;
    /*
    * Customer(ACTOR) is going to add this ticket
    * then make it login / ask for credentials
    *
    * Before Springlets the customer hit this method, it already has
    * its username and password.
    *
    * ask spring this customers username using principal
    * */
    @PostMapping("/add")
    public void add(@Valid  @RequestBody TicketReqDto dto,
                    Principal principal){
        String customerUsername = principal.getName();
        ticketService.add(dto,customerUsername);

    }

    /* Get all for customer */
    @GetMapping("/all/for-customer")
    public List<TicketRespDto> getTicketsByCustomer(Principal principal,
                                                    @RequestParam(defaultValue = "0", required = false) int page,
                                                    @RequestParam(defaultValue = "10", required = false) int size){
        String customerUsername = principal.getName();
        return ticketService.getTicketsByCustomer(page,size,customerUsername);
    }

    /* Get all for executive */
    @GetMapping("/all/for-executive")
    public List<TicketExecutiveResponseDto> getTicketsByExecutive(Principal principal,
                                                                  @RequestParam(defaultValue = "0", required = false) int page,
                                                                  @RequestParam(defaultValue = "10", required = false) int size){
        String executiveUsername = principal.getName();
        return ticketService.getTicketsByExecutive(executiveUsername, page,size);


    }
    /*
    * Assign Ticket to executive
    * To be done only by ADMIN
    * */
    @PostMapping("/assign/{executiveId}/{ticketId}")
    public void assignTicketToExecutive(@PathVariable int executiveId,
                                        @PathVariable int ticketId){
        ticketService.assignTicketToExecutive(executiveId,ticketId);

    }

}
