package com.example.CompanyManagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class config {

    // Define a RestTemplate bean
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}