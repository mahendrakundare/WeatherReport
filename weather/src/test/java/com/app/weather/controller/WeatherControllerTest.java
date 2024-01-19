package com.app.weather.controller;

import com.app.weather.model.Location;
import com.app.weather.model.Weather;
import com.app.weather.service.WeatherService;
import org.apache.coyote.BadRequestException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
class WeatherControllerTest {
    @InjectMocks
    private WeatherController weatherController;

    @Mock
    WeatherService weatherService;

    @Test
    void fetchWeatherSummaryByCityName_shouldReturnResponseForTheGiveCity() throws BadRequestException {
        Weather weather = getWeather();
        String cityName = "berlin";
        when(weatherService.fetchWeatherSummaryByCityName(anyString())).thenReturn(ResponseEntity.ok(weather));

        ResponseEntity<Weather> response = weatherController.fetchWeatherSummaryByCityName(cityName);

        assertThat(response.getStatusCode().is2xxSuccessful());
        assertThat(response.getBody().getLocation().getName().equals(cityName));
    }

    @Test
    void fetchHourlyWeatherByCityName_shouldReturnResponseForTheGiveCity() throws BadRequestException {
        Weather weather = getWeather();
        String cityName = "berlin";
        when(weatherService.fetchHourlyWeatherByCityName(cityName)).thenReturn(ResponseEntity.ok(weather));

        ResponseEntity<Weather> response = weatherController.fetchHourlyWeatherByCityName(cityName);

        assertThat(response.getStatusCode().is2xxSuccessful());
        assertThat(response.getBody().getLocation().getName().equals(cityName));
    }

    @Test
    void shouldThrowErrorIfCitNameIsInvalid() {
        assertThrows(BadRequestException.class, () -> weatherController.fetchWeatherSummaryByCityName("invalid city name1334"));
    }

    public Weather getWeather() {
        Weather weather = new Weather();
        Location location = new Location();
        location.setName("berlin");
        weather.setLocation(location);
        return weather;
    }
}