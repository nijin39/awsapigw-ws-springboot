package com.proserve.kal.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggingConfig {

    @Bean
    public CommonsRequestLoggingFilter requestLoggingFilter() {
        CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
        loggingFilter.setIncludeHeaders(true);
        loggingFilter.setIncludeQueryString(true);
        loggingFilter.setIncludePayload(true);
        loggingFilter.setMaxPayloadLength(100);
        loggingFilter.setIncludeClientInfo(true);
        loggingFilter.setBeforeMessagePrefix("Before : ");
        loggingFilter.setBeforeMessageSuffix("");
        loggingFilter.setAfterMessagePrefix("After : ");
        loggingFilter.setAfterMessageSuffix("");
        return loggingFilter;
    }
}
