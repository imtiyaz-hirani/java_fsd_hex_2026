package com.service;

import com.exception.ResourceNotFoundException;
import com.model.Ticket;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

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

    public void deleteRecord(int id) {

        Transaction tx = session.beginTransaction();
        // Validate ID -- find the id in DB and fetch the object
        Ticket ticket = session.find(Ticket.class, id);
        if(ticket == null) {
            tx.commit();
            throw new ResourceNotFoundException("Invalid ID given..");
        }

        // Remove the object
        session.remove(ticket);
        tx.commit();
    }

    public List<Ticket> getAllTickets() {
        Transaction tx = session.beginTransaction();
        List<Ticket> list = session
                            .createQuery("from Ticket", Ticket.class)
                            .list();
        tx.commit();
        return list;
    }

    public Ticket getById(int id) {
        Transaction tx = session.beginTransaction();
        Ticket ticket = session.find(Ticket.class, id);
        tx.commit();
        if(ticket == null)
             throw new ResourceNotFoundException("Invalid ID given..");

        return ticket;

    }
}
/*
SQL: select * from ticket
HQL: from Ticket
* */
