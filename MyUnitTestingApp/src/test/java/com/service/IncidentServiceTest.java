package com.service;

import com.enums.IncidentStatus;
import com.enums.IncidentType;
import com.exception.ResourceNotFoundException;
import com.model.Incident;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class IncidentServiceTest {

    IncidentService incidentService = new IncidentService();
    List<Incident> list;

    @BeforeEach
    public void init(){
        Incident incident1 = new Incident(1, IncidentType.ABUSE, "Case file created.", IncidentStatus.INITIATED);
        Incident incident2 = new Incident(2, IncidentType.THEFT, "Security footage under review.", IncidentStatus.ACTIVE);
        Incident incident3 = new Incident(3, IncidentType.MISSING_PERSON, "Statement confirmed.", IncidentStatus.VERIFIED);
        Incident incident4 = new Incident(4, IncidentType.MURDER, "Documentation finalized.", IncidentStatus.CLOSE);

        list = List.of(incident1,incident2,incident3,incident4);
    }
    @Test
    public void getByIdTest(){
        Incident incident2 = new Incident(2, IncidentType.THEFT, "Security footage under review.", IncidentStatus.ACTIVE);
        // Use Case : ID present
        Assertions.assertEquals(incident2,incidentService.getById(list, 2));

        // Use Case : ID Not Present
        ResourceNotFoundException e =
        Assertions.assertThrows(ResourceNotFoundException.class, ()->incidentService.getById(list, 10));
        Assertions.assertEquals("Invalid Id given!!!" , e.getMessage());
    }

    @Test
    public void getByStatusTest(){

    }

    @Test
    public void getByTypeTest(){

    }

    @AfterEach
    public void complete(){
        list = null;
    }
}
