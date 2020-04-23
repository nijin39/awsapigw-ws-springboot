package com.proserve.kal.reservation.infra;

import com.amazonaws.services.apigatewaymanagementapi.AmazonApiGatewayManagementApi;
import com.amazonaws.services.apigatewaymanagementapi.model.PostToConnectionRequest;
import com.proserve.kal.reservation.application.dto.RequestInfo;
import com.proserve.kal.reservation.domain.SendResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.ByteBuffer;

@Component
public class SendResultTOAPIGW implements SendResult {

    @Autowired
    AmazonApiGatewayManagementApi amazonApiGatewayManagementApi;

    @Override
    public void sendToAPIGW(RequestInfo requestInfo) {
        PostToConnectionRequest request = new PostToConnectionRequest();
        request.withConnectionId(requestInfo.getConnectionId());
        request.withData(ByteBuffer.wrap("{\"message\":\"Receive Booking Request\", \"status\":\"finished\"}".getBytes()));
        amazonApiGatewayManagementApi.postToConnection(request);

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        request.withData(ByteBuffer.wrap("{\"message\":\"Receive Booking Request 2\", \"status\":\"finished\"}".getBytes()));
        amazonApiGatewayManagementApi.postToConnection(request);
    }
}
