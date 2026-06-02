package com.springboot.SupportFlowLite.repository;

import com.springboot.SupportFlowLite.model.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.net.ContentHandler;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    @Query("""
            select t
            from Ticket t
            where t.customer.user.username=?1
            """)
    Page<Ticket> getTicketsByCustomer(String customerUsername, Pageable pageable);

    @Query("""
            select t
            from Ticket t
            where t.executive.user.username=?1
            """)
    Page<Ticket> getTicketsByExecutive(String executiveUsername, Pageable pageable);
}
