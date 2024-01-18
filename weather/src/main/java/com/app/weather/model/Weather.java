package com.app.weather.model;

public class Weather {
    String cityName;
    String status;

    public Weather(String cityName, String status) {
        this.cityName = cityName;
        this.status = status;
    }

    public String getCityName() {
        return cityName;
    }

    public String getStatus() {
        return status;
    }
}
