package com.springboot.SupportFlowLite.mapper;

import com.springboot.SupportFlowLite.dto.CustomerReqDto;
import com.springboot.SupportFlowLite.model.Customer;
import jakarta.validation.Valid;

public class CustomerMapper {
    public static Customer mapDtoToEntity(@Valid CustomerReqDto customerReqDto) {
        Customer customer = new Customer();
        customer.setName(customerReqDto.name());
        customer.setEmail(customerReqDto.email());
        customer.setPhoneNumber(customerReqDto.phoneNumber());
        return customer;
    }
}
