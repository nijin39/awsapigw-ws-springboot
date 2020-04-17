package com.proserve.kal.reservation.application.dto;

import lombok.Data;

@Data
public class RequestInfo {
    private String connectionId;
    private WSRequestBody body;

    @Data
    private class WSRequestBody {
        private String action;
        private String message;
    }
}
