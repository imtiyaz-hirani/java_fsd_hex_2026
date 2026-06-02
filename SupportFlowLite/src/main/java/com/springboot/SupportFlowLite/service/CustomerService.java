package com.springboot.SupportFlowLite.service;

import com.springboot.SupportFlowLite.dto.CustomerReqDto;
import com.springboot.SupportFlowLite.enums.Role;
import com.springboot.SupportFlowLite.mapper.CustomerMapper;
import com.springboot.SupportFlowLite.mapper.UserMapper;
import com.springboot.SupportFlowLite.model.Customer;
import com.springboot.SupportFlowLite.model.User;
import com.springboot.SupportFlowLite.repository.CustomerRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public void add(@Valid CustomerReqDto customerReqDto) {
        // Step 1: Map dto to Customer Entity
        Customer customer = CustomerMapper.mapDtoToEntity(customerReqDto);

        // Step 2: Map dto to User entity
        User user =  UserMapper.mapDtoToEntity(customerReqDto);

        user.setRole(Role.CUSTOMER);
        // Step 2.1 : Encode ur password
        user.setPassword(passwordEncoder.encode(customerReqDto.password()));

        // STEP 2.5 : Save the USer
        user  = userService.save(user);

        // Step 3: Attach user to Customer
        customer.setUser(user);

        // Step 4: Save Customer
        customerRepository.save(customer);
    }

    public Customer getByUsername(String customerUsername) {
        return customerRepository.findByUserUsername(customerUsername);
    }
}
