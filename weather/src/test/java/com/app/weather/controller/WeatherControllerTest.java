package com.app.weather.controller;

import com.app.weather.model.Weather;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WeatherControllerTest {
    @InjectMocks
    private WeatherController weatherController;

    @Test
    void fetchWeatherSummaryByCityName_shouldReturnResponseForTheGiveCity() {
        ResponseEntity<Weather> response = weatherController.fetchWeatherSummaryByCityName("berlin");

        assertEquals("", "");
        assertThat(response.getStatusCode().is2xxSuccessful());
        assertThat(response.getBody().getCityName().equals("berlin"));
        assertThat(response.getBody().getStatus().equals("cold"));
    }

    @Test
    void fetchHourlyWeatherByCityName_shouldReturnResponseForTheGiveCity() {
        ResponseEntity<Weather> response = weatherController.fetchHourlyWeatherByCityName("berlin");

        assertEquals("", "");
        assertThat(response.getStatusCode().is2xxSuccessful());
        assertThat(response.getBody().getCityName().equals("berlin"));
        assertThat(response.getBody().getStatus().equals("cold"));
    }
}