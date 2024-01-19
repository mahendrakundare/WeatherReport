package com.app.weather.service;

import com.app.weather.config.AppProperties;
import com.app.weather.model.Weather;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;


@Service
public class WeatherServiceImpl implements WeatherService {

    private final RestTemplate restTemplate;

    private final AppProperties appProperties;

    public static final String AUTH_HEADER_HOST = "X-RapidAPI-Host";
    public static final String AUTH_HEADER_SECRET_KEY = "X-RapidAPI-Key";

    public WeatherServiceImpl(RestTemplate restTemplate, AppProperties appProperties) {
        this.restTemplate = restTemplate;
        this.appProperties = appProperties;
    }


    @Override
    public ResponseEntity<Weather> fetchWeatherSummaryByCityName(String city) {
       return fetchResponse(appProperties.getWeatherSummaryApi(), city);
    }

    @Override
    public ResponseEntity<Weather> fetchHourlyWeatherByCityName(String city) {
        return fetchResponse(appProperties.getHourlyWeatherApi(), city);
    }

    private ResponseEntity<Weather> fetchResponse(String url, String city) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        headers.set(AUTH_HEADER_HOST, appProperties.getHostKey());
        headers.set(AUTH_HEADER_SECRET_KEY, appProperties.getHeaderKey());
        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            return restTemplate.exchange(url, HttpMethod.GET, entity, Weather.class, city);
        } catch (RestClientResponseException e) {
            Weather weather = new Weather();
            weather.setErrorMessage(e.getMessage());
            return ResponseEntity
                    .status(e.getRawStatusCode())
                    .body(weather);
        }
    }

}
