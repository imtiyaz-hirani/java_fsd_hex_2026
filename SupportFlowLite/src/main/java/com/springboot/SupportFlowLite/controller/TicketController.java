package com.springboot.SupportFlowLite.controller;

import com.springboot.SupportFlowLite.dto.TicketReqDto;
import com.springboot.SupportFlowLite.service.TicketService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

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
}
