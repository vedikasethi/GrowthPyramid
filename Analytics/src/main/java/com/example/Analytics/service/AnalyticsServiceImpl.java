package com.example.Analytics.service;

import com.example.OrderManagement.entity.Order;
import com.example.OrderManagement.repository.OrderRepository;
import com.example.Analytics.service.AnalyticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnalyticsServiceImpl implements AnalyticsService {

    private final OrderRepository orderRepository;

    // 1️⃣ Get total sales per month
    @Override
    public Map<String, Double> getTotalSalesPerMonth(Long companyId) {
        List<Order> orders = orderRepository.findOrdersByCompanyId(companyId);
        SimpleDateFormat monthFormat = new SimpleDateFormat("yyyy-MM");

        return orders.stream()
                .collect(Collectors.groupingBy(
                        order -> monthFormat.format(order.getOrderDate()),
                        Collectors.summingDouble(Order::getAmount)
                ));
    }

    // 2️⃣ Get top-selling product
    @Override
    public String getTopSellingProduct(Long companyId) {
        List<Order> orders = orderRepository.findOrdersByCompanyId(companyId);

        return orders.stream()
                .collect(Collectors.groupingBy(Order::getProductName, Collectors.summingInt(Order::getQuantity)))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())  // Get the product with the highest quantity
                .map(Map.Entry::getKey)
                .orElse("No orders found");
    }

    // 3️⃣ Get sales by city
    @Override
    public Map<String, Double> getSalesByCity(Long companyId) {
        List<Order> orders = orderRepository.findOrdersByCompanyId(companyId);

        return orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getCity,
                        Collectors.summingDouble(Order::getAmount)
                ));
    }
}
