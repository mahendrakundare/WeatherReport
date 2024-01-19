package com.app.weather.controller;

import com.app.weather.model.Weather;
import com.app.weather.service.WeatherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }


    @GetMapping("/weather/{city}/summary")
    public ResponseEntity<Weather> fetchWeatherSummaryByCityName(@PathVariable String city) {
        return weatherService.fetchWeatherSummaryByCityName(city);
    }

    @GetMapping("/weather/{city}/hourly")
    public ResponseEntity<Weather> fetchHourlyWeatherByCityName(@PathVariable String city) {
        return weatherService.fetchHourlyWeatherByCityName(city);
    }

}
