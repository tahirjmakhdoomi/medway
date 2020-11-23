package com.stackroute.Medicine.Service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableEurekaClient
@SpringBootApplication
@EnableDiscoveryClient
public class MedicineServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicineServiceApplication.class, args);
	}

}
