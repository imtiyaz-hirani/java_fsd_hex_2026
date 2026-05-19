package com.service;

import com.model.Ticket;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TicketService {

    private final Session session;

    public TicketService(Session session) {
        this.session = session;
    }


    public void insert(Ticket ticket) {
        // begin the transaction
        Transaction tx = session.beginTransaction();
        //DB Op
        session.persist(ticket);

        tx.commit();
    }
}
