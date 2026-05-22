package com.app.dao_impl;

import com.app.dao.TicketDao;
import com.app.model.Ticket;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class TicketDaoImpl implements TicketDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Ticket> findAll(String customerUsername) {
        TypedQuery<Ticket> query =  entityManager
                .createQuery("select t from Ticket t where t.customer.user.username=:username", Ticket.class);
        query.setParameter("username", customerUsername);
        return query.getResultList();

    }
}
