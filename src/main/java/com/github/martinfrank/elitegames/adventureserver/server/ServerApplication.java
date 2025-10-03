package com.github.martinfrank.elitegames.adventureserver.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServerApplication.class);

	public static void main(String[] args) {
        LOGGER.debug("Adventure Server started");
		SpringApplication.run(ServerApplication.class, args);
	}

}
