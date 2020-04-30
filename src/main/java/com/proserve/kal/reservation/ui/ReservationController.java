package com.proserve.kal.reservation.ui;

import com.proserve.kal.reservation.application.ReservationService;
import com.proserve.kal.reservation.application.dto.RequestInfo;
import com.proserve.kal.reservation.application.dto.ReservationRequest;
import com.proserve.kal.reservation.application.dto.ReservationResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/hello")
    public String healthCheck(){
        return "OK";
    }
//1초, 3초, 7초, 15초, 45초
    @GetMapping("/delay/1")
    public String delayedResponse_1(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "OK";
    }

    @GetMapping("/delay/3")
    public String delayedResponse_3(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "OK";
    }

    @GetMapping("/delay/7")
    public String delayedResponse_5(){
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "OK";
    }

    @GetMapping("/delay/15")
    public String delayedResponse_15(){
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "OK";
    }

    @GetMapping("/delay/45")
    public String delayedResponse_45(){
        try {
            Thread.sleep(45000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "OK";
    }

    @PostMapping("/api-gw")
    public String getApiGwInfo(@RequestBody RequestInfo requestInfo) throws InterruptedException {
        log.info("CONNECTION ID " + requestInfo.getConnectionId());
        log.info("REQUEST BODY " + requestInfo.getBookingParams());
        reservationService.makeReservation(requestInfo);
        //log.info("RequestInfo "+requestInfo);
        return "Accepted a request"; //Result 전송 --> 요청접수
    }

    @PostMapping("/header")
    public String showParams(@RequestBody String header){
        log.info("Header {}", header);
        return header;
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
