package com.service;

import com.enums.IncidentStatus;
import com.enums.IncidentType;
import com.exception.ResourceNotFoundException;
import com.model.Incident;

import java.util.List;

public class IncidentService {

    public Incident getById(List<Incident> list, int id){

        return list
                .stream()
                .filter(incident -> incident.getId() == id)
                .findFirst()
                    .orElseThrow(()->new ResourceNotFoundException("Invalid Id given!!!"));

         /*
        return list
                .stream()
                .filter(incident -> incident.getId() == id)
                .toList()
                .getFirst();
        */
    }

    public List<Incident> getByStatus(List<Incident> list, IncidentStatus status) {

        return list.stream()
                .filter(incident -> incident.getIncidentStatus().equals(status))
                .toList();
    }

    public List<Incident> getByType(List<Incident> list, IncidentType type){
        return null;
    }
}
