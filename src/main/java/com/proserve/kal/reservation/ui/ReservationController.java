package com.proserve.kal.reservation.ui;

import com.proserve.kal.reservation.application.ReservationService;
import com.proserve.kal.reservation.application.dto.ReservationRequest;
import com.proserve.kal.reservation.application.dto.ReservationResult;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

@Log
@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/hello")
    public String healthCheck(){
        log.info("HELLO");
        return "OK";
    }

    @GetMapping("/api-gw")
    public String getApiGwInfo(){
        return "OK";
    }

    @GetMapping("/delay-test")
    public String delayTest() throws InterruptedException {
        log.info("DELAY Enter");
        Thread.sleep(32000);
        return "Delayed";
    }

    @PostMapping
    public ReservationResult makeReservation(@RequestBody ReservationRequest reservationRequest){
        return reservationService.makeReservation(reservationRequest);
    }
}
