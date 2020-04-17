package com.proserve.kal.reservation.ui;

import com.proserve.kal.reservation.application.ReservationService;
import com.proserve.kal.reservation.application.dto.RequestInfo;
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

    @PostMapping("/api-gw")
    public String getApiGwInfo(@RequestBody String requestInfo){
//        log.info("CONNECTION ID " + requestInfo.getConnectionId());
//        log.info("REQUEST BODY " + requestInfo.getBody());
        //reservationService.makeReservation(params);
        log.info("RequestInfo "+requestInfo);
        return "Accepted a request"; //Result 전송 --> 요청접수
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
