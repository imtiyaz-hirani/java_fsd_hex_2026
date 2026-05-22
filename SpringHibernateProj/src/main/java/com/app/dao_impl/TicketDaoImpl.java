package com.app.dao_impl;

import com.app.dao.TicketDao;
import com.app.enums.Status;
import com.app.model.Customer;
import com.app.model.Ticket;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
 public class TicketDaoImpl implements TicketDao {

    @PersistenceContext
    private EntityManager entityManager;

    private CustomerDaoImpl customerDao;

    @Autowired
    public void setCustomerDao(CustomerDaoImpl customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public List<Ticket> findAll(String customerUsername) {
        TypedQuery<Ticket> query =  entityManager
                .createQuery("select t from Ticket t where t.customer.user.username=:username", Ticket.class);
        query.setParameter("username", customerUsername);
        return query.getResultList();

    }

    @Override
    public void save(Ticket ticket,String customerUsername) {
        Customer customer = customerDao.getByUsername(customerUsername);
        // attach customer to ticket
        ticket.setCustomer(customer);
        // set ticket status
        ticket.setStatus(Status.OPEN);

        entityManager.persist(ticket);
    }
}
