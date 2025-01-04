package com.gfg.L09_Logging_MVC_demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class L09LoggingMvcDemoApplication {

	private static Logger LOGGER = LoggerFactory.getLogger(L09LoggingMvcDemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(L09LoggingMvcDemoApplication.class, args);
		LOGGER.error("Logging error level");
		LOGGER.warn("Logging warn level");
		LOGGER.info("Logging Info level");
		LOGGER.debug("Logging debug level");
		LOGGER.trace("Logging trace level");
	}

}
