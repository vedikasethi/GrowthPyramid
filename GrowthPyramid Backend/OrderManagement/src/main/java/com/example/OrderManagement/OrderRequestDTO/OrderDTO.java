package com.example.OrderManagement.OrderRequestDTO;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class OrderDTO {
    private String productName;
    private Double amount;
    private Integer quantity;
    private String city;
    // Return the companyId field
    @Getter
    private Long companyId; // Add the companyId field
    private Date orderdate; // Field to store the order creation date and time


}
