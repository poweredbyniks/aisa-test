package com.niks.carwash;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class CarWashApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarWashApplication.class, args);
	}

}
