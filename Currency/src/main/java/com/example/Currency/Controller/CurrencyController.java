package com.example.Currency.Controller;

import com.example.CompanyManagement.entity.Company;
import com.example.Currency.Service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/currency")
@RequiredArgsConstructor
public class CurrencyController {

    private final CurrencyService currencyService;

    // Add balance coins to a company
    @PutMapping("/add/{companyId}/{coins}")
    public ResponseEntity<Company> addCoins(@PathVariable Long companyId, @PathVariable int coins) {
        Company updatedCompany = currencyService.addCoins(companyId, coins);
        return updatedCompany != null ? ResponseEntity.ok(updatedCompany)
                : ResponseEntity.badRequest().build();
    }

    // Update balance coins (set a new value)
    @PutMapping("/update/{companyId}/{newBalance}")
    public ResponseEntity<Company> updateCoins(@PathVariable Long companyId, @PathVariable int newBalance) {
        Company updatedCompany = currencyService.updateCoins(companyId, newBalance);
        return updatedCompany != null ? ResponseEntity.ok(updatedCompany)
                : ResponseEntity.badRequest().build();
    }
}
