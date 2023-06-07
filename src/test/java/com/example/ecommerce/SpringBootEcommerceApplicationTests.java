package com.example.ecommerce;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootEcommerceApplicationTests {

	public static Logger logger=LoggerFactory.getLogger(SpringBootEcommerceApplicationTests.class);
	
	@Test
	void contextLoads() {
		logger.info("Testcase executing");
		assertEquals(true,true);
	}

}
