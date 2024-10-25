package com.example.orders;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class OnlineOrdersApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineOrdersApplication.class, args);
		log.info("App is started!");
	}

}
