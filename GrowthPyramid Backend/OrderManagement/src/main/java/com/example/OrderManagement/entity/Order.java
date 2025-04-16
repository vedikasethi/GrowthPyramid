package com.example.OrderManagement.entity;

import com.example.CompanyManagement.entity.Company;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private String productName;
    private Double amount;
    private Integer quantity;
    private String city;

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderdate; // Field to store the order creation date and time

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company; // Reference to the Company entity
}
