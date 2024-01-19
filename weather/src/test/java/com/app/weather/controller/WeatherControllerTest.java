package com.app.weather.controller;

import com.app.weather.model.Location;
import com.app.weather.model.Weather;
import com.app.weather.service.WeatherService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
class WeatherControllerTest {
    @InjectMocks
    private WeatherController weatherController;

    @Mock
    WeatherService weatherService;

    @Test
    void fetchWeatherSummaryByCityName_shouldReturnResponseForTheGiveCity() {
        Weather weather = getWeather();
        String cityName = "berlin";
        when(weatherService.fetchWeatherSummaryByCityName(cityName)).thenReturn(ResponseEntity.ok(weather));

        ResponseEntity<Weather> response = weatherController.fetchWeatherSummaryByCityName(cityName);

        assertThat(response.getStatusCode().is2xxSuccessful());
        assertThat(response.getBody().getLocation().getName().equals(cityName));
    }

    @Test
    void fetchHourlyWeatherByCityName_shouldReturnResponseForTheGiveCity() {
        Weather weather = getWeather();
        String cityName = "berlin";
        when(weatherService.fetchHourlyWeatherByCityName(cityName)).thenReturn(ResponseEntity.ok(weather));

        ResponseEntity<Weather> response = weatherController.fetchHourlyWeatherByCityName(cityName);

        assertThat(response.getStatusCode().is2xxSuccessful());
        assertThat(response.getBody().getLocation().getName().equals(cityName));
    }

    public Weather getWeather() {
        Weather weather = new Weather();
        Location location = new Location();
        location.setName("berlin");
        weather.setLocation(location);
        return weather;
    }
}