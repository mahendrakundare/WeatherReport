package com.app.weather.model;

public class Error {
    private String statusCode;

    private String message;

    public Error(String statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }
}
