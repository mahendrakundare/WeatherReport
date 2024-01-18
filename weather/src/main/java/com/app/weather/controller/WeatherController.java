package com.app.weather.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {
    @GetMapping("message")
    public String getMessage() {
        String response = "Hello welcome to springboot";
        return  response;
    }

}
