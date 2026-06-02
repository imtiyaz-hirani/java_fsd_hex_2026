package com.springboot.SupportFlowLite.repository;

import com.springboot.SupportFlowLite.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Customer findByUserUsername(String username);
}
