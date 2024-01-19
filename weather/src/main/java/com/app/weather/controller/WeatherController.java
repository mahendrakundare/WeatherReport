package com.app.weather.controller;

import com.app.weather.model.Weather;
import com.app.weather.service.WeatherService;
import org.apache.commons.lang3.StringUtils;
import org.apache.coyote.BadRequestException;
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
    public ResponseEntity<Weather> fetchWeatherSummaryByCityName(@PathVariable String city) throws BadRequestException {
        String capitalizeName = capitalizeName(city);
        return weatherService.fetchWeatherSummaryByCityName(capitalizeName);
    }

    @GetMapping("/weather/{city}/hourly")
    public ResponseEntity<Weather> fetchHourlyWeatherByCityName(@PathVariable String city) throws BadRequestException {
        String capitalizeName = capitalizeName(city);
        return weatherService.fetchHourlyWeatherByCityName(capitalizeName);
    }

    private String capitalizeName(String city) throws BadRequestException {
        if (StringUtils.isBlank(city) || !StringUtils.isAlphaSpace(city)) {
            throw new BadRequestException("Please Enter valid city name");
        }
        return StringUtils.capitalize(city.trim());
    }

}
