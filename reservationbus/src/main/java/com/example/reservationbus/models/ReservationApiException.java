package com.example.reservationbus.models;

import org.springframework.http.HttpStatus;

public class ReservationApiException extends RuntimeException{

    private final HttpStatus status;
    private final String message;

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public ReservationApiException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
