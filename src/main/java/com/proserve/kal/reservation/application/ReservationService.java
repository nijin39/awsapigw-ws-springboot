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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.nio.ByteBuffer;

@Service
public class ReservationService {

    @Autowired
    private ReservationReceipt reservationReceipt;


    public ReservationResult makeReservation(ReservationRequest reservationRequest) {
        return reservationReceipt.acceptance(reservationRequest);
    }

    @Async
    public void makeReservation(RequestInfo requestInfo) throws InterruptedException {
        // Doing Reservation
        AmazonApiGatewayManagementApiClientBuilder builder = AmazonApiGatewayManagementApiClientBuilder.standard();

        String endpointUri = "https://jkcibhqy65.execute-api.ap-northeast-2.amazonaws.com/dev";

        AwsClientBuilder.EndpointConfiguration endpointConfiguration = new AwsClientBuilder.EndpointConfiguration(
                endpointUri, "ap-northeast-2"
        );

        AmazonApiGatewayManagementApi agma = builder
                .withEndpointConfiguration(endpointConfiguration)
                .withCredentials(new ProfileCredentialsProvider("default"))
                .build();

        PostToConnectionRequest request = new PostToConnectionRequest();

        request.withConnectionId(requestInfo.getConnectionId());

        request.withData(ByteBuffer.wrap("{\"message\":\"Receive Booking Request\", \"status\":\"start\"}".getBytes()));
        agma.postToConnection(request);

        Thread.sleep(10000);

        request.withData(ByteBuffer.wrap("{\"message\":\"Request to Booking System\", \"status\":\"doing\"}".getBytes()));
        agma.postToConnection(request);

        Thread.sleep(10000);

        request.withData(ByteBuffer.wrap("{\"message\":\"Finished Booking\", \"status\":\"finished\"}".getBytes()));
        agma.postToConnection(request);

    }
}
