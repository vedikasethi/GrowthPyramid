package com.example.OrderManagement.mycontroller;


import com.example.OrderManagement.OrderRequestDTO.OrderDTO;
import com.example.OrderManagement.entity.Order;
import com.example.OrderManagement.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor


public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<String> createOrder(@RequestBody OrderDTO orderDTO) {
        try {
            Order createdOrder = orderService.createOrder(orderDTO);
            return ResponseEntity.ok("Order Created Successfully with ID: " + createdOrder.getOrderId());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error: " + e.getMessage());
        }
    }
}
