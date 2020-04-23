package com.proserve.kal.common.config;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.apigatewaymanagementapi.AmazonApiGatewayManagementApi;
import com.amazonaws.services.apigatewaymanagementapi.AmazonApiGatewayManagementApiClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmazonSDKConfig {

    @Bean
    public AmazonApiGatewayManagementApi settingAPIGWConnection(){
        AmazonApiGatewayManagementApiClientBuilder builder = AmazonApiGatewayManagementApiClientBuilder.standard();
        String endpointUri = "https://jkcibhqy65.execute-api.ap-northeast-2.amazonaws.com/dev";

        AwsClientBuilder.EndpointConfiguration endpointConfiguration = new AwsClientBuilder.EndpointConfiguration(
                endpointUri, "ap-northeast-2"
        );

        AmazonApiGatewayManagementApi agma = builder
                .withEndpointConfiguration(endpointConfiguration)
                .withCredentials(DefaultAWSCredentialsProviderChain.getInstance())
                .build();
        return agma;
    }
}
