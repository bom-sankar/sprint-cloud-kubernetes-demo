package com.travel.agency.service.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgencyController {

    @GetMapping("/deals")
    public String getDeals(){
        return "Agency Deals";
    }

    @GetMapping()
    public String get(){
        return "Test Message";
    }
}
