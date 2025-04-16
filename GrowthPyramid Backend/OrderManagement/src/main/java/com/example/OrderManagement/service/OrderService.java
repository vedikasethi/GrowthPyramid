package com.example.OrderManagement.service;

import com.example.OrderManagement.OrderRequestDTO.OrderDTO;
import com.example.OrderManagement.entity.Order;
import com.example.OrderManagement.OrderMapping.OrderMapping;
import com.example.OrderManagement.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    private final RestTemplate restTemplate;

    @Value("${http://COMPANY-MANAGEMENT/api/company}") // e.g., "http://COMPANY-MANAGEMENT/api/company"
    private String companyServiceUrl;

    public Order createOrder(OrderDTO orderDTO, Long companyIdFromURL) {
        Order order = OrderMapping.toEntity(orderDTO, companyIdFromURL);
        return orderRepository.save(order);
    }

}
