package com.example.ecommerce;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootEcommerceApplication {
	
	public static Logger logger=LoggerFactory.getLogger(SpringBootEcommerceApplication.class);

	@PostConstruct
	public void init() {
		logger.info("Application Started..");
	}
	
	
	public static void main(String[] args) {
		logger.info("Application Executed");
		SpringApplication.run(SpringBootEcommerceApplication.class, args);
	}

}
