package com.controller;

import com.model.Customer;
import com.service.CustomerService;

import java.util.List;

public class CustomerController {

    public static void main(String[] args) {
        // Reach out to Service class : Create an Object
        CustomerService customerService = new CustomerService();
        List<Customer> list =  customerService.getAllCustomers();
        list.forEach(System.out :: println);
    }
}
