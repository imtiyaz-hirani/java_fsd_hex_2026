package com.service;

import com.model.Executive;
import com.model.Ticket;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HrService {
    private final Session session;
    private TicketService ticketService;
    private ExecutiveService executiveService;

    public HrService(Session session) {
        this.session = session;
        this.ticketService = new TicketService(session);
        this.executiveService = new ExecutiveService(session);
    }


    public void assignExecutiveToTicket(int ticketId, int executiveId) {

        // verify ticketId and fetch ticket object
        Ticket ticket = ticketService.getById(ticketId);

        // verify executiveId and fetch executive Object
        Executive executive = executiveService.getById(executiveId);

        // attach executive to ticket
        ticket.setExecutive(executive);

        // re-persist ticket
        Transaction tx = session.beginTransaction();
        session.persist(ticket);
        tx.commit();
    }
}
