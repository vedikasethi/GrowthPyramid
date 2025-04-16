package com.example.OrderManagement.OrderRequestDTO;

import lombok.*;
import org.springframework.stereotype.Component;

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

}
