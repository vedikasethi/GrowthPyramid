package com.example.Currency.CurrencyDTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CurrencyTransactionDTO {

    private Long transactionid;
    private Long companyIdsender;
    private Long companyIdreciever;
    private int coinsChanged;
}
