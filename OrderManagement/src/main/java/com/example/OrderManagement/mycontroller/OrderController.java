package com.example.OrderManagement.mycontroller;

import com.example.OrderManagement.entity.Order;
import com.example.OrderManagement.repository.OrderRepository;
import com.example.OrderManagement.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    // Ingest a new order
    @PostMapping("/ingest/{companyId}")
    public ResponseEntity<Order> ingestOrder(@PathVariable Long companyId, @RequestBody Order order) {
        Order savedOrder = orderService.ingestOrder(companyId, order);
        return savedOrder != null ? ResponseEntity.ok(savedOrder)
                : ResponseEntity.badRequest().build();
    }

    // Delete an order by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long id) {
        boolean isDeleted = orderService.deleteOrder(id);
        return isDeleted ? ResponseEntity.ok("Order deleted successfully")
                : ResponseEntity.badRequest().body("Order not found");
    }
}
