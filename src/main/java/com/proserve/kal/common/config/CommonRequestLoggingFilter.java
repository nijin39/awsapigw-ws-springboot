package com.proserve.kal.common.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.AbstractRequestLoggingFilter;

import javax.servlet.http.HttpServletRequest;

@Slf4j
class CommonsRequestLoggingFilter extends AbstractRequestLoggingFilter {
    @Override
    protected boolean shouldLog(HttpServletRequest request) {
        return log.isDebugEnabled();
    }
    /**
     * Writes a log message before the request is processed.
     */
    @Override
    protected void beforeRequest(HttpServletRequest request, String message) {
        log.debug(message);
    }
    /**
     * Writes a log message after the request is processed.
     */
    @Override
    protected void afterRequest(HttpServletRequest request, String message) {
        logger.debug(message);
    }
}
