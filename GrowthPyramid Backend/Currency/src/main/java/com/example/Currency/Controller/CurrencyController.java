package com.example.Currency.Controller;

import com.example.Currency.CurrencyDTO.CurrencyTransactionDTO;
import com.example.Currency.Entity.Currency;
import com.example.Currency.Service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/currency")
@RequiredArgsConstructor
public class CurrencyController {

    private final CurrencyService currencyService;

    @PostMapping("/transaction/{sendingcompanyIdFromURL}/{recievingcompanyIdFromURL}")
    public ResponseEntity<Currency> createCurrencyTransaction(
            @RequestBody CurrencyTransactionDTO currencyTransactionDTO,
            @PathVariable Long sendingcompanyIdFromURL,  @PathVariable Long recievingcompanyIdFromURL) {

        // Call the service to create a currency transaction
        Currency currency = currencyService.createCurrencyTransaction(currencyTransactionDTO, sendingcompanyIdFromURL,recievingcompanyIdFromURL );

        // Return the response with HTTP status 201 (Created)
        return ResponseEntity.status(201).body(currency);
    }

    @PostMapping("/addbalance/{companyId}")
    public ResponseEntity<Currency> addBalance(
            @RequestBody CurrencyTransactionDTO currencyTransactionDTO,
            @PathVariable Long companyId) {

        // Call the service to add balance
        Currency currency = currencyService.addBalance(currencyTransactionDTO, companyId);

        // Return the response with HTTP status 201 (Created)
        return ResponseEntity.status(201).body(currency);
    }
}
