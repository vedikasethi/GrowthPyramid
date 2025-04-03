package com.example.Currency.Repository;

import com.example.Currency.Entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface currencyRepository extends JpaRepository<Currency, Long> {
}
