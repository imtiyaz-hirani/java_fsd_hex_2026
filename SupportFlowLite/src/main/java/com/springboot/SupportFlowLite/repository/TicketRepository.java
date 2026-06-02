package com.springboot.SupportFlowLite.repository;

import com.springboot.SupportFlowLite.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}
