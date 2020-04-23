package com.proserve.kal.reservation.domain;

import com.proserve.kal.reservation.application.dto.RequestInfo;

public interface SendResult {
    void sendToAPIGW(RequestInfo requestInfo);
}
