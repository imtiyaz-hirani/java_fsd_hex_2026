package com.app.dao_impl;

import com.app.dao.IncidentDao;
import com.app.exceptions.ResourceNotFoundException;
import com.app.model.Incident;

import java.util.List;

public class IncidentDaoImpl implements IncidentDao {
    @Override
    public void insert(Incident incident) {

    }

    @Override
    public List<Incident> getAll() {
        return List.of();
    }

    @Override
    public Incident getById(int id) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public void deleteById(int id) throws ResourceNotFoundException {

    }

    @Override
    public void update(int id, Incident incident) throws ResourceNotFoundException {

    }
}
