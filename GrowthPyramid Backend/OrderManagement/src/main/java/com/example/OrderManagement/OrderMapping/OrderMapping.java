package com.example.OrderManagement.OrderMapping;

import com.example.OrderManagement.OrderRequestDTO.OrderDTO;
import com.example.OrderManagement.entity.Order;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderMapping {

    public static Order toEntity(OrderDTO dto, Long companyId) {
        return Order.builder()
                .companyId(companyId) // Use the companyId parameter
                .productName(dto.getProductName())
                .amount(dto.getAmount())
                .quantity(dto.getQuantity())
                .city(dto.getCity())
                .build();
    }

    public static OrderDTO toDTO(Order order) {
        return OrderDTO.builder()
                .productName(order.getProductName())
                .amount(order.getAmount())
                .quantity(order.getQuantity())
                .city(order.getCity())
                .companyId(order.getCompanyId()) // Include companyId in the DTO
                .build();
    }
}
