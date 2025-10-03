package com.github.martinfrank.elitegames.adventureserver.server;

import org.junit.jupiter.api.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class LogTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogTest.class);

    @Test
    void testLogs() {
        LOGGER.info("INFO ->>>>>>>>>>>>>>>");
        LOGGER.trace("TRACE ->>>>>>>>>>>>>>>");
        LOGGER.debug("DEBUG ->>>>>>>>>>>>>>>");
        LOGGER.warn("WARN ->>>>>>>>>>>>>>>");
        LOGGER.error("ERROR ->>>>>>>>>>>>>>");
    }
}
