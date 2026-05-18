package com.service;

import com.enums.IncidentStatus;
import com.enums.IncidentType;
import com.model.Incident;
import com.repository.IncidentRepository;

import java.sql.SQLException;
import java.util.List;

public class IncidentService {
    OfficerService officerService = new OfficerService();
    IncidentRepository incidentRepository = new IncidentRepository();

    public void addIncident(String username, IncidentType incidentType, String details, IncidentStatus incidentStatus)
            throws SQLException {
        // Fetch Officer id from this username
        int officerId = officerService.getOfficerId(username);

        // Prepare the object
        Incident incident = new Incident();
        incident.setIncidentType(incidentType);
        incident.setIncidentStatus(incidentStatus);
        incident.setProgressDetails(details);
        incidentRepository.insertIncident(incident, officerId);


    }

    public List<Incident> getAllIncidents() {
        return incidentRepository.getAllIncidents();
    }
}
