package com.app.weather.controller;

import com.app.weather.model.Location;
import com.app.weather.model.Weather;
import com.app.weather.service.WeatherService;
import org.apache.commons.lang3.StringUtils;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
        if (isInputInvalid(city)) {
            Weather weather = new Weather();
            weather.setErrorMessage("Please Enter valid city name");
            return ResponseEntity.badRequest().body(weather);
        }
        return weatherService.fetchWeatherSummaryByCityName(StringUtils.capitalize(city));
    }

    @GetMapping("/weather/{city}/hourly")
    public ResponseEntity<Weather> fetchHourlyWeatherByCityName(@PathVariable String city) {
        if (isInputInvalid(city)) {
            Weather weather = new Weather();
            weather.setErrorMessage("Please Enter valid city name");
            return ResponseEntity.badRequest().body(weather);
        }
        return weatherService.fetchHourlyWeatherByCityName(StringUtils.capitalize(city));
    }

    private boolean isInputInvalid(String city) {
        return StringUtils.isBlank(city) || !StringUtils.isAlphaSpace(city);
    }

}
