package com.proserve.kal.reservation.application.dto;

import lombok.Data;

@Data
public class RequestInfo {
    private String connectionId;
    private BookingParams bookingParams;

    @Data
    private class BookingParams {
        private String action;
        private String message;
    }
}