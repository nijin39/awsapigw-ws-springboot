package com.proserve.kal.reservation.application.dto;

import lombok.Data;

@Data
public class RequestInfo {
    private String connectionId;
    private BookingParams bookingParams;

    @Data
    public class BookingParams {
        private String action;
        private String message;
        private Integer delay;
    }
}