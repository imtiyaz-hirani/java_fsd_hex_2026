package com.springboot.SupportFlowLite.controller;

import com.springboot.SupportFlowLite.dto.CustomerReqDto;
import com.springboot.SupportFlowLite.service.CustomerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/add")
    public void add(@Valid  @RequestBody CustomerReqDto customerReqDto){
        customerService.add(customerReqDto);
    }
}
