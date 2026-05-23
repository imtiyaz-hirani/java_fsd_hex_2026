package com.cms.service;

import com.cms.model.Incident;
import com.cms.repository.IncidentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/*
To create a bean in spring boot we can use following annotations
for services class use @Service
for repositories , use @Repository
for all other classes including util use @Component
* */
@Service
@AllArgsConstructor
public class IncidentService {

    private final IncidentRepository incidentRepository;

    public List<Incident> getAll() {
        return incidentRepository.findAll();
    }
}
