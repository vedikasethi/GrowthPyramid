package com.example.Currency.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "currency_transaction")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionid;

    private Long companyIdsender;

    private Long companyIdreciever;

    private Double newBalance;  // Change balance to Double for fractional amounts
    // Automatically sets the transaction time

}
