package com.example.Collaboration_Request;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@EntityScan(basePackages = {
		"com.example.CompanyManagement.entity",
		"com.example.Collaboration_Request.entity"
})
public class CollaborationRequestApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollaborationRequestApplication.class, args);
	}

}
