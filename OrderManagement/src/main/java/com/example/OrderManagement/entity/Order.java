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

    @ManyToOne
    @JoinColumn(name = "companyId", nullable = false)
    private Company company;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private double amount;

    @Temporal(TemporalType.DATE)
    private Date orderDate = new Date();  // Default to today

    @Column(nullable = false)
    private int quantity;

    @Column(length = 50, nullable = false)
    private String city;
}
