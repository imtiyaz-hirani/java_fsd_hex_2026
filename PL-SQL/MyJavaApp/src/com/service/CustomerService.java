package com.service;

import com.model.Customer;
import com.repository.CustomerRepository;

import java.util.List;

public class CustomerService {

    CustomerRepository customerRepository = new CustomerRepository();

    public List<Customer> getAllCustomers() {
       return customerRepository.getAllCustomers();
    }
}
