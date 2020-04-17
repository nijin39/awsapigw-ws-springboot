package com.proserve.kal.reservation.application;

import com.proserve.kal.reservation.application.dto.ReservationRequest;
import com.proserve.kal.reservation.application.dto.ReservationResult;
import com.proserve.kal.reservation.domain.ReservationReceipt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    @Autowired
    private ReservationReceipt reservationReceipt;

    public ReservationResult makeReservation(ReservationRequest reservationRequest) {
        return reservationReceipt.acceptance(reservationRequest);
    }
}
