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
    private Long CompanyID;

    @Column(length = 20, nullable = false, unique = true)
    private String username;

    @Column(nullable = false, length = 60) // Ensure sufficient length for BCrypt
    private String password;

    @Column(length = 20, nullable = false)
    private String companyName;

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
    private String contactDesignation;

    @Column(length = 10, columnDefinition = "BIGINT DEFAULT 0")
    private Long balance = 0L;
}
