package com.cms.controller;

import com.cms.model.Incident;
import com.cms.service.IncidentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
* In controller if you are creating REST APIs
* then add
* @RestController annotation which is a combo of
* @Controller & @ResponseBody
* But if you are using this controller to load java UI(jsp or Thymeleaf)
* then use only @Controller
* */
@RestController
@AllArgsConstructor
public class IncidentController {

    private final IncidentService incidentService;

    @GetMapping("/api/incident/all")
    public List<Incident> getAll(){
        return incidentService.getAll();
    }
}
