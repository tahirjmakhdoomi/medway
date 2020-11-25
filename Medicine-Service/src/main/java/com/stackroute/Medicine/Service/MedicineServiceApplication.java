package com.stackroute.Medicine.Service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EnableDiscoveryClient
public class MedicineServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicineServiceApplication.class, args);
	}

}
