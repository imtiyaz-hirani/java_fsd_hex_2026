package com.cms.controller;

import org.springframework.web.bind.annotation.RestController;

/*
* In controller if you are creating REST APIs
* then add
* @RestController annotation which is a combo of
* @Controller & @ResponseBody
* But if you are using this controller to load java UI(jsp or Thymeleaf)
* then use only @Controller
* */
@RestController
public class IncidentController {
}
