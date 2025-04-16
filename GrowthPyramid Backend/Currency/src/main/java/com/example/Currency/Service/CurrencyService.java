package com.example.Currency.Service;

import com.example.Currency.CurrencyDTO.CurrencyTransactionDTO;
import com.example.Currency.Entity.Currency;
import com.example.Currency.Mapper.CurrencyMapper;
import com.example.Currency.Repository.currencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class CurrencyService {

    private final currencyRepository currencyRepository;
    private final RestTemplate restTemplate;

    @Value("${http://COMPANY-MANAGEMENT/api/company}")
    private String companyServiceUrl;

    public Currency createCurrencyTransaction(CurrencyTransactionDTO currencyTransactionDTO, Long sendingcompanyIdFromURL, Long recievingcompanyIdFromURL) {
        Currency currency = CurrencyMapper.toEntity(currencyTransactionDTO, sendingcompanyIdFromURL, recievingcompanyIdFromURL);
        return currencyRepository.save(currency);
    }

    public Currency addBalance(int balance, Long companyId) {
        getCompanyById
        return currencyRepository.save(currency);
    }
}
