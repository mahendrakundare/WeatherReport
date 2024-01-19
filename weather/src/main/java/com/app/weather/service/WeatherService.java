package com.app.weather.service;

import com.app.weather.model.Weather;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public interface WeatherService {
    ResponseEntity<Weather> fetchWeatherSummaryByCityName(String city);
    ResponseEntity<Weather> fetchHourlyWeatherByCityName(String city);
}
