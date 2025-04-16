package com.example.Collaboration_Request;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CollaborationRequestApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollaborationRequestApplication.class, args);
	}

}
