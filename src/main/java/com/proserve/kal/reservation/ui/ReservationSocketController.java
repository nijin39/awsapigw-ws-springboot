package com.proserve.kal.reservation.ui;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ReservationSocketController {

    @MessageMapping("/reservation")
    @SendTo("/topic/reservation-result")
    public String greeting(String message) throws Exception {
        Thread.sleep(35000); // simulated delay
        return "Hello "+message;
    }

}
