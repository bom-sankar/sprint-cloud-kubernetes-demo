package com.client.service.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TravelAgencyService {

    private final RestTemplate restTemplate;

    public TravelAgencyService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "getFallbackName", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000") })
    public String getDeals(){
        return this.restTemplate.getForObject("http://travel-agency-service:8002/deals", String.class);
    }

    private String getFallbackName() {
        return "Fallback";
    }

}
