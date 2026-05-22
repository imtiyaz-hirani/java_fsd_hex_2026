package com.service;

import com.exception.ResourceNotFoundException;
import com.model.Executive;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ExecutiveService {

    private final Session session;

    public ExecutiveService(Session session) {
        this.session = session;
    }

    public Executive getById(int executiveId) {
        Transaction tx = session.beginTransaction();
        Executive executive = session.find(Executive.class, executiveId);
        if(executive == null)
            throw new ResourceNotFoundException("Invalid executive Id.");
        tx.commit();
        return executive;
    }
}
