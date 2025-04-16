package com.example.OrderManagement.mycontroller;


import com.example.CompanyManagement.Mapping.CompanyMapping;
import com.example.CompanyManagement.companyDTO.CompanyDTO;
import com.example.CompanyManagement.entity.Company;
import com.example.OrderManagement.OrderRequestDTO.OrderDTO;
import com.example.OrderManagement.entity.Order;
import com.example.OrderManagement.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor


public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create/{id}")
    public ResponseEntity<Order> createOrder(@PathVariable Long id, @RequestBody OrderDTO orderDTO) {
        Order createdOrder = orderService.createOrder(orderDTO, id);
        return ResponseEntity.ok(createdOrder);
    }

}
