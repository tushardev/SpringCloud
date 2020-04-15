package com.spring.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class RateController {

    @Value("${rate}")
    private String rate;

    @Value("${lanecount}")
    private String lanecount;

    @Value("${tollstart}")
    private String tollstart;

    @Value("${company}")
    private String company;

    @RequestMapping("/rate")
    public String getRate() {
        return "Welcome to Toll System. Your rate is: " + rate + " Your Lanecount is: " + lanecount + " And Company is " + company;
    }
}
