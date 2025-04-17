package com.example.OrderManagement.service;

import com.example.CompanyManagement.entity.Company;
import com.example.OrderManagement.OrderRequestDTO.OrderDTO;
import com.example.OrderManagement.entity.Order;
import com.example.OrderManagement.OrderMapping.OrderMapping;
import com.example.OrderManagement.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public Order createOrder(OrderDTO orderDTO) {

        // Fetch the Company entity from the database to ensure it is managed
        Company managedCompany = entityManager.find(Company.class, orderDTO.getCompanyId());
        if (managedCompany == null) {
            throw new IllegalArgumentException("Company with ID: " + orderDTO.getCompanyId() + " does not exist in the database.");
        }

        // Map OrderDTO to Order entity
        Order order = OrderMapping.toEntity(orderDTO, managedCompany);
        order.setOrderdate(new Date()); // Set the current timestamp as the order date
        return orderRepository.save(order);
    }
}