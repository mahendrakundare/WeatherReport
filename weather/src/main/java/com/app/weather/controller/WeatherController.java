package com.app.weather.controller;

import com.app.weather.model.Weather;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class WeatherController {

    @GetMapping("/weather/{city}/summary")
    public ResponseEntity<Weather> fetchWeatherSummaryByCityName(@PathVariable String city) {
        Weather response = new Weather(city, "Cold");
        return  new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/weather/{city}/hourly")
    public ResponseEntity<Weather> fetchHourlyWeatherByCityName(@PathVariable String city) {
        Weather response = new Weather(city, "Cold");
        return  new ResponseEntity<>(response, HttpStatus.OK);
    }

}
