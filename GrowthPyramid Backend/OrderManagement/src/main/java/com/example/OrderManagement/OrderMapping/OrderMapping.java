package com.example.OrderManagement.OrderMapping;

import com.example.CompanyManagement.entity.Company;
import com.example.OrderManagement.OrderRequestDTO.OrderDTO;
import com.example.OrderManagement.entity.Order;

public class OrderMapping {

    public static Order toEntity(OrderDTO dto, Company company) {
        return Order.builder()
                .productName(dto.getProductName())
                .amount(dto.getAmount())
                .quantity(dto.getQuantity())
                .city(dto.getCity())
                .orderdate(dto.getOrderdate())
                .company(company) // Set the Company entity
                .build();
    }

    public static OrderDTO toDTO(Order order) {
        return OrderDTO.builder()
                .productName(order.getProductName())
                .amount(order.getAmount())
                .quantity(order.getQuantity())
                .city(order.getCity())
                .companyId(order.getCompany().getCompanyID()) // Get companyId from the Company entity
                .orderdate(order.getOrderdate())
                .build();
    }
}