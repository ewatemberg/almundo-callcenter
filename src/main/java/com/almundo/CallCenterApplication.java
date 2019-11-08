package com.almundo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CallCenterApplication {
	
	private static Logger LOGGER = LoggerFactory.getLogger(CallCenterApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CallCenterApplication.class, args);
	}

}
