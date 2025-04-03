package com.example.OrderManagement.service;

import com.example.CompanyManagement.repository.CompanyRepository;
import com.example.CompanyManagement.entity.Company;
import com.example.OrderManagement.entity.Order;
import com.example.OrderManagement.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final CompanyRepository companyRepository;

    // Ingest a new order
    public Order ingestOrder(Long companyId, Order order) {
        Optional<Company> company = companyRepository.findById(companyId);
        if (company.isPresent()) {
            order.setCompany(company.get());
            order.setOrderDate(new Date()); // Set current date
            return orderRepository.save(order);
        }
        return null;
    }

    // Delete an order by ID
    public boolean deleteOrder(Long id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
