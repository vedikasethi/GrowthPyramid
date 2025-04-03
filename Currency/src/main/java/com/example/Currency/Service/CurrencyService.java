package com.example.Currency.Service;


import com.example.CompanyManagement.entity.Company;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.CompanyManagement.repository.CompanyRepository;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CurrencyService {

    private final CompanyRepository companyRepository;

    // Add coins to a company
    public Company addCoins(Long companyId, int coins) {
        Optional<Company> companyOpt = companyRepository.findById(companyId);
        if (companyOpt.isPresent()) {
            Company company = companyOpt.get();
            company.setBalanceCoins(company.getBalanceCoins() + coins); // Adding coins
            return companyRepository.save(company);
        }
        return null;
    }

    // Update the balance coins of a company (set new value)
    public Company updateCoins(Long companyId, int newBalanceCoins) {
        Optional<Company> companyOpt = companyRepository.findById(companyId);
        if (companyOpt.isPresent()) {
            Company company = companyOpt.get();
            company.setBalanceCoins(newBalanceCoins); // Overwriting the balance
            return companyRepository.save(company);
        }
        return null;
    }
}
