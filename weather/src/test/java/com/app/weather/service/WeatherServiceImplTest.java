package com.app.weather.service;

import com.app.weather.config.AppProperties;
import com.app.weather.model.Location;
import com.app.weather.model.Weather;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static com.app.weather.service.WeatherServiceImpl.AUTH_HEADER_HOST;
import static com.app.weather.service.WeatherServiceImpl.AUTH_HEADER_SECRET_KEY;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WeatherServiceImplTest {

    @InjectMocks
    WeatherServiceImpl weatherService;

    @Mock
    AppProperties appProperties;

    @Mock
    RestTemplate restTemplate;


    @Test
    void fetchWeatherSummaryByCityName_shouldSucceed() {
        Weather weather = getWeather();
        String cityName = "berlin";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        headers.set(AUTH_HEADER_HOST, "X-RapidAPI-Host");
        headers.set(AUTH_HEADER_SECRET_KEY, "random-key");
        HttpEntity<String> entity = new HttpEntity<>(headers);
        when(appProperties.getHostKey()).thenReturn("X-RapidAPI-Host");
        when(appProperties.getHeaderKey()).thenReturn("random-key");
        when(appProperties.getWeatherSummaryApi()).thenReturn("http://dummyURL:8080/berlin/summary");
        when(restTemplate.exchange("http://dummyURL:8080/berlin/summary", HttpMethod.GET, entity, Weather.class)).thenReturn(new ResponseEntity<>(weather, HttpStatus.OK));

        ResponseEntity<Weather> response = weatherService.fetchWeatherSummaryByCityName(cityName);

        assertThat(response.getStatusCode().is2xxSuccessful());
        assertThat(response.getBody().getLocation().getName().equals(cityName));
    }

    @Test
    void fetchHourlyWeatherByCityName_shouldSucceed() {
        Weather weather = getWeather();
        String cityName = "berlin";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        headers.set(AUTH_HEADER_HOST, "X-RapidAPI-Host");
        headers.set(AUTH_HEADER_SECRET_KEY, "random-key");
        HttpEntity<String> entity = new HttpEntity<>(headers);
        when(appProperties.getHostKey()).thenReturn("X-RapidAPI-Host");
        when(appProperties.getHeaderKey()).thenReturn("random-key");
        when(appProperties.getHourlyWeatherApi()).thenReturn("http://dummyURL:8080/berlin/hourly");
        when(restTemplate.exchange("http://dummyURL:8080/berlin/hourly", HttpMethod.GET, entity, Weather.class)).thenReturn(new ResponseEntity<>(weather, HttpStatus.OK));



        ResponseEntity<Weather> response = weatherService.fetchHourlyWeatherByCityName(cityName);

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