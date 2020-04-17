package com.proserve.kal.reservation.domain;

import com.proserve.kal.reservation.application.dto.ReservationRequest;
import com.proserve.kal.reservation.application.dto.ReservationResult;

public interface ReservationReceipt {
    ReservationResult acceptance(ReservationRequest reservationRequest);
}
