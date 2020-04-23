package com.proserve.kal.reservation.application;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.apigatewaymanagementapi.AmazonApiGatewayManagementApi;
import com.amazonaws.services.apigatewaymanagementapi.AmazonApiGatewayManagementApiClientBuilder;
import com.amazonaws.services.apigatewaymanagementapi.model.PostToConnectionRequest;
import com.proserve.kal.reservation.application.dto.RequestInfo;
import com.proserve.kal.reservation.application.dto.ReservationRequest;
import com.proserve.kal.reservation.application.dto.ReservationResult;
import com.proserve.kal.reservation.domain.ReservationReceipt;
import com.proserve.kal.reservation.domain.SendResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.nio.ByteBuffer;

@Service
public class ReservationService {

    @Autowired
    private ReservationReceipt reservationReceipt;

    @Autowired
    private SendResult sendResult;


    public ReservationResult makeReservation(ReservationRequest reservationRequest) {
        return reservationReceipt.acceptance(reservationRequest);
    }

    @Async
    public void makeReservation(RequestInfo requestInfo) throws InterruptedException {
        // Doing Reservation

        sendResult.sendToAPIGW(requestInfo);
    }
}
