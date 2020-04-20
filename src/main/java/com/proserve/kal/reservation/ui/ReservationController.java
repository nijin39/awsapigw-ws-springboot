package com.proserve.kal.reservation.ui;

import com.amazonaws.util.StringUtils;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.proserve.kal.reservation.application.ReservationService;
import com.proserve.kal.reservation.application.dto.RequestInfo;
import com.proserve.kal.reservation.application.dto.ReservationRequest;
import com.proserve.kal.reservation.application.dto.ReservationResult;
import lombok.extern.java.Log;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Log
@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/hello")
    public String healthCheck(){
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
