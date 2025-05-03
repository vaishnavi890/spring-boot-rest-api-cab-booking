package com.vaishnavi.cab.booking.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LoggingService {

    private final Logger logger = LoggerFactory.getLogger(LoggingService.class);

    public String log() {
        logger.trace("Cab Booking TRACE: Trace message for internal diagnostics.");
        logger.debug("Cab Booking DEBUG: Debug message for development tracking.");
        logger.info("Cab Booking INFO: General system info message.");
        logger.warn("Cab Booking WARN: Warning about potential issue.");
        logger.error("Cab Booking ERROR: Error occurred in the Cab Booking system.");

        return "Logging done! Check Cab Booking System logs for detailed output.";
    }
}


