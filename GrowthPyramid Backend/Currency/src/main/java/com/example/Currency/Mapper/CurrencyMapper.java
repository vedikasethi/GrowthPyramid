package com.example.Currency.Mapper;

import com.example.Currency.Entity.Currency;
import com.example.Currency.CurrencyDTO.CurrencyTransactionDTO;

public class CurrencyMapper {

    // Method to map CurrencyTransactionDTO to Currency entity
    public static Currency toEntity(CurrencyTransactionDTO dto, Long sendingcompanyIdFromURL, Long recievingcompanyIdFromURL) {
        return Currency.builder()
                .transactionid(dto.getTransactionid())
                .companyIdsender(sendingcompanyIdFromURL)
                .companyIdreciever(recievingcompanyIdFromURL)
                .newBalance((double) dto.getCoinsChanged())  // Assuming coinsChanged is an integer, converting it to double
                .build();
    }

    // Method to map Currency entity to CurrencyTransactionDTO
    public static CurrencyTransactionDTO toDTO(Currency currency) {
        return CurrencyTransactionDTO.builder()
                .transactionid(currency.getTransactionid())
                .companyIdsender(currency.getCompanyIdsender())
                .companyIdreciever(currency.getCompanyIdreciever())
                .coinsChanged(currency.getNewBalance().intValue())  // Assuming you need to return coinsChanged as int
                .build();
    }
}
