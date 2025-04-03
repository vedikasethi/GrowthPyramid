package com.example.CompanyManagement.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "company")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;

    @Column(nullable = false)
    private int balanceCoins;

    @Column(nullable = false)
    private double balance;

    @Column(length = 20, nullable = false)
    private String category;

    @Column(length = 100)
    private String description;

    @Column(length = 20, nullable = false)
    private String contactName;

    @Column(nullable = false)
    private Long contactNumber;

    @Column(length = 20, nullable = false, unique = true)
    private String contactMailId;

    @Column(length = 20)
    private String contactDesg;
}
