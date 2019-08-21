package com.client.service.controllers;

import com.client.service.config.ClientConfig;
import com.client.service.services.TravelAgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    ClientConfig clientConfig;

    @Autowired
    private TravelAgencyService travelAgencyService;

    @GetMapping("/deals")
    public String deals(){
        return travelAgencyService.getDeals();
    }

    @GetMapping()
    public String load(){
        return String.format(clientConfig.getMessage(), "", "");
    }
}
