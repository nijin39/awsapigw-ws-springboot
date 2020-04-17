package com.proserve.kal.reservation.infra;

import com.proserve.kal.reservation.application.dto.ReservationRequest;
import com.proserve.kal.reservation.application.dto.ReservationResult;
import com.proserve.kal.reservation.domain.ReservationReceipt;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.springframework.stereotype.Component;

@Component
public class AmadeusReceipt implements ReservationReceipt {

    @Override
    public ReservationResult acceptance(ReservationRequest reservationRequest) {

        HttpResponse<String> response = Unirest.post("http://localhost:8081/booking/flight-order")
                .header("content-type", "application/json")
                .body("{\"username\":\"gary\",\"requestId\":\"002\"}")
                .asString();

        String reservationId = "001";

        ReservationResult reservationResult = new ReservationResult();
        reservationResult.setReservationId(reservationId);

        return reservationResult;
    }
}
