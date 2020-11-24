package com.stackroute.Medicine.Service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MedicineServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicineServiceApplication.class, args);
	}

}
