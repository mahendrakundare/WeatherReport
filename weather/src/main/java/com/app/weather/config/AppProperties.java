package com.app.weather.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties()
public class AppProperties {

    @Value("${app.weather-summary-api}")
    private String weatherSummaryApi;

    @Value("${app.weather-hourly-api}")
    private String hourlyWeatherApi;

    @Value("${app.header-key}")
    private String headerKey;

    @Value("${app.host-key}")
    private String hostKey;

    public String getWeatherSummaryApi() {
        return weatherSummaryApi;
    }

    public String getHourlyWeatherApi() {
        return hourlyWeatherApi;
    }

    public String getHeaderKey() {
        return headerKey;
    }

    public String getHostKey() {
        return hostKey;
    }
}

